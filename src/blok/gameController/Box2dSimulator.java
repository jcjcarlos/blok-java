/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blok.gameController;

import blok.gameController.AdapterPoint;
import blok.gui.MainPanel;
import blok.interfaces.ISimulator;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.Contact;

/**
 *
 * @author sandroandrade
 */
public class Box2dSimulator implements ISimulator, Runnable, ContactListener {

	private Box2dSimulator() {
	}

	public static Box2dSimulator getInstance() {
		if (simulator == null)
			simulator = new Box2dSimulator();
		return simulator;
	}

	public void setMainPanel(MainPanel mainPanel) {
		m_mainPanel = mainPanel;
	}

	public void start() {
		m_schedulerHandle = m_scheduler.scheduleAtFixedRate(this, 0, 3, TimeUnit.MILLISECONDS);
	}

	public void stop() {
		m_schedulerHandle.cancel(true);
	}

	@Override
	public void run() {
		m_world.step(B2_TIMESTEP, B2_VELOCITY_ITERATIONS, B2_POSITION_ITERATIONS);
		// m_mainPanel.bodiesUpdated(m_bodies);
		pointsUpdate(m_points);
		m_mainPanel.pointsUpdated(m_points);
	}

	public void init() {
		m_world = new World(new Vec2(0, -10f), true);
		m_world.setContactListener(this);
		m_bodies.clear();
		m_points.clear();

		// Ground
		m_ground = createBody(0.0f, -260.0f, 900.0f, 20.0f, false, 1.0f, 0.3f, 0.5f);

		// Blocks
		int i = 0, j = 0;
		for (i = 0; i < 10; ++i)
			for (j = 0; j < 11 - i; ++j) {
				m_bodies.add(
						createBody(-150.0f + 15 * i + 30 * j, -236.0f + 30 * i, 28.0f, 28.0f, true, 1.0f, 0.3f, 0.5f));
				m_points.add(new AdapterPoint(-150.0f + 15 * i + 30 * j, -236.0f + 30 * i));
				// System.out.println(m_points.get(m_points.size()-1));
				// System.out.println(m_bodies.get(m_bodies.size()-1).getPosition().x
				// +" "+m_bodies.get(m_bodies.size()-1).getPosition().y);
			}

		// Player
		j -= 2;
		m_bodies.add(m_player = createBody(-150.0f + 15 * i + 30 * j, -236.0f + 30 * i + 14, 56.0f, 56.0f, true, 1.0f,
				0.3f, 0.5f));
		m_player.setUserData("player");

		m_points.add(new AdapterPoint(-150.0f + 15 * i + 30 * j, -236.0f + 30 * i + 14, true));

		// m_mainPanel.bodiesCreated(m_bodies);
		m_mainPanel.pointsCreated(m_points);
	}

	private Body createBody(float x, float y, float width, float height, boolean dynamic, float density, float friction,
			float restitution) {
		BodyDef bodyDef = new BodyDef();
		if (dynamic)
			bodyDef.type = BodyType.DYNAMIC;
		bodyDef.position.set(x, y);
		Body body = m_world.createBody(bodyDef);
		PolygonShape box = new PolygonShape();
		box.setAsBox(width / 2, height / 2);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = box;
		fixtureDef.density = density;
		fixtureDef.friction = friction;
		fixtureDef.restitution = restitution;
		body.createFixture(fixtureDef);
		body.setSleepingAllowed(true);

		return body;
	}

	public void removeBody(Body body) {
		m_world.destroyBody(body);
		m_bodies.remove(body);
		if (m_bodies.size() == 2) {
			stop();
			m_mainPanel.setState(MainPanel.State.YOUWON);
		}
	}

	public void removeBody(AdapterPoint point) {
		removeBody(getBody(point));
	}

	private Body getBody(AdapterPoint point) {
		for (int i = 0; i < m_points.size(); i++)
			if (m_points.get(i).equals(point)) {
				Body temp = m_bodies.get(i);
				m_points.remove(i);
				return temp;
			}
		return null;
	}

	private void pointsUpdate(ArrayList<AdapterPoint> m_points) {
		for (int i = 0; i < m_bodies.size(); i++) {
			m_points.get(i).setX(m_bodies.get(i).getPosition().x);
			m_points.get(i).setY(m_bodies.get(i).getPosition().y);
		}

	}

	@Override
	public void beginContact(Contact contact) {
		if ((contact.getFixtureA().getBody() == m_ground && contact.getFixtureB().getBody() == m_player)
				|| (contact.getFixtureB().getBody() == m_ground && contact.getFixtureA().getBody() == m_player)) {
			stop();
			m_mainPanel.setState(MainPanel.State.YOULOST);
		}
	}

	@Override
	public void endContact(Contact arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact arg0, ContactImpulse arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact arg0, Manifold arg1) {
		// TODO Auto-generated method stub

	}

	private static float PI = 3.14159265359f;
	private static float B2_TIMESTEP = 1.0f / 30.0f;
	private static int B2_VELOCITY_ITERATIONS = 8;
	private static int B2_POSITION_ITERATIONS = 4;

	private static Box2dSimulator simulator = null;
	private MainPanel m_mainPanel;

	private final ScheduledExecutorService m_scheduler = Executors.newScheduledThreadPool(1);
	private ScheduledFuture<?> m_schedulerHandle = null;

	private static World m_world;
	private ArrayList<Body> m_bodies = new ArrayList<Body>();
	private ArrayList<AdapterPoint> m_points = new ArrayList<AdapterPoint>();
	private Body m_player = null;
	private Body m_ground = null;

}
