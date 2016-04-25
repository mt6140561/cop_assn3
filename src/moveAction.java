import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;

public class moveAction extends AbstractAction{
	public Bat bat;
	public String key;
	public int bool;
	public Map<String, Bat> pressed;
	public moveAction(Bat bat, String key, int bool, HashMap<String, Bat> pre){
		this.bat = bat;
		this.key = key;
		this.bool = bool;
		pressed = pre;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (bool == 0) {
			bat.velo = 0;
			pressed.remove(key);
		} else {
			pressed.put(key, bat);
		}
//		System.out.println(bat.pos);
	}

}
