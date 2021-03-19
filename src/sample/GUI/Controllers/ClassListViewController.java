package sample.GUI.Controllers;

import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.BE.Student;
import sample.BLL.StudentBLLManager;

import java.net.URL;
import java.util.ResourceBundle;

public class ClassListViewController implements Initializable {
    public TableView<Student> tblClassList;
    public TableColumn<Student, String> colName;
    public TableColumn<Student, Integer> colAttendance;

    private StudentBLLManager studentBLLManager;

    public ClassListViewController() {
        studentBLLManager =  new StudentBLLManager();
    }

    /**
     * Loads students and lists them with their attendance
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tblClassList.setItems(studentBLLManager.loadStudents());
            colName.setCellValueFactory(celldata -> Bindings.concat(celldata.getValue().nameProperty(), " ", celldata.getValue().lastNameProperty()));
            colAttendance.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        colAttendance.setSortType(TableColumn.SortType.DESCENDING);
        tblClassList.getSortOrder().add(colAttendance);

    }
}
