class Student{
    private String name;
    private String id;
    private String grade;
    public Student(String name, String id, String grade){
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
}
//Displaying student details
class StudentView{
    public void displayStudentDetails(String studentName, String studentId, String studentGrade){
        System.out.println("Student:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}
//Controller Class
class StudentController{
    private Student model;
    private StudentView view;
    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }
    public void setStudentName(String name){
        model.setName(name);
    }
    public String getStudentName(){
        return model.getName();
    }
    public void setStudentId(String id){
        model.setId(id);
    }
    public String getStudentId(){
        return model.getId();
    }
    public void setStudentGrade(String grade){
        model.setGrade(grade);
    }
    public String getStudentGrade(){
        return model.getGrade();
    }
    public void updateView(){
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
public class MVCPatternExample{
    public static void main(String[] args){
        Student model = new Student("Swetha", "21CSE091", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        // Display initial details
        System.out.println("Initial Student Details:");
        controller.updateView();
        System.out.println();

        // Updating
        controller.setStudentName("Swetha S");
        controller.setStudentGrade("A+");

        // Display updated details
        System.out.println("Updated Student Details:");
        controller.updateView();
    }
}