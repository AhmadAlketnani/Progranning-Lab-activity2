import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

public class MyEvent implements EventHandler<ActionEvent> {

    ListView listView;
    public MyEvent(ListView listView) {
    this.listView=listView;
    }

    @Override
    public void handle(ActionEvent event) {
        CheckBox checkBox = ((CheckBox) event.getSource());
        if (checkBox.isSelected()){
            listView.getItems().add(checkBox.getText());
        }else {
            listView.getItems().remove(checkBox.getText());
        }
    }
}
