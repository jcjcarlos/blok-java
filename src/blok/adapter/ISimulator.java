package blok.adapter;


public interface ISimulator {
	public void run();
	public void start();
	public void init();
	public void stop();
	public void removeBody(Ponto p);
}
