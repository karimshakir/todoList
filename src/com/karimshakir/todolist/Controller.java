package com.karimshakir.todolist;

import com.karimshakir.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.security.acl.LastOwnerException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;

    @FXML
    private TextArea itemDetailTextArea;


    public void initialize() {
        TodoItem item1 = new TodoItem("Buy new shoes, Jon", "Tevin to get the shoes",
                LocalDate.of(2017, Month.MARCH, 22));
        TodoItem item2 = new TodoItem("Doctor appointment Jon","Jeff to go to doctor",
                LocalDate.of(2017, Month.MAY, 23));
        TodoItem item3 = new TodoItem("Design proposal Jon","Cory to present propsal",
                LocalDate.of(2017, Month.APRIL, 22));
        TodoItem item4 = new TodoItem("Pickup Dog for Jon","Jason to pickup Dog",
                LocalDate.of(2017, Month.MARCH, 23));
        TodoItem item5 = new TodoItem("Laundry Pick up Jon","Kate to grap laundry",
                LocalDate.of(2017, Month.APRIL, 20));


        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll((todoItems));
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView(){
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        //System.out.println("The selected item is " + item);
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailTextArea.setText(sb.toString());
    }
}
