package blok.adapter;

import java.util.ArrayList;
import blok.gui.MainPanel.State;

public interface IMainPanel {
	public void bodiesCreated(ArrayList<Ponto> pontos);
	public void bodiesUpdate(ArrayList<Ponto> pontos);
	public void setState(State state);
}
