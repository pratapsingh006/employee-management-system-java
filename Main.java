import java.util.*;
class Main{

    public static int readInt(Scanner sc){
        while(true){
            try{
                return sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Enter ! please Enter a number");
                sc.nextLine();
            }
        }
    }

    public static double readDouble(Scanner sc){
        while(true){
            try{
                return sc.nextDouble();
            }
            catch(InputMismatchException e){
                System.out.println("invalid input ! please Enter a valid number");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        while(true){
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. delete Employee");
            System.out.println("6. Search Department");
            System.out.println("7. Sort Employee by Salary");
            System.out.println("8. Exit");

            System.out.println("Enter your choice: ");
            int choice = readInt(sc);
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Employee id: ");
                    int id = readInt(sc);
                    sc.nextLine();

                    String name;
                    while (true) {
                        System.out.print("Enter your name: ");
                        name = sc.nextLine().trim();

                        if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                            break;
                        }

                        System.out.println("Invalid name! Use letters and spaces only.");
                    }

                    String email;
                    while(true){
                        System.out.println("Enter your Email: ");
                        email = sc.nextLine().trim();

                        if(email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")){
                            break;
                        }

                        System.out.println("Invalid email! Please enter a valid email.");
                    }

                    String department;

                    while (true) {
                        System.out.print("Enter your Department: ");
                        department = sc.nextLine().trim();

                        if (!department.isEmpty()
                                && department.matches("[a-zA-Z ]+")) {
                            break;
                        }

                        System.out.println("Invalid department! Use letters and spaces only.");
                    }

                    System.out.println("Enter Salary: ");
                    Double salary = readDouble(sc);

                    Employee employee = new Employee(id,name,email,department,salary);

                    employees.add(employee);
                    System.out.println("Employee added succesfully! ");
                    break;

                case 2:
                    if(employees.isEmpty()){
                        System.out.println("no employees found. ");
                    }
                    else{
                        System.out.println("\n----- Employee List -----");

                        for(Employee emp : employees){
                            System.out.println("Id: "+emp.getId());
                            System.out.println("Name: "+emp.getName());
                            System.out.println("Mail: "+emp.getEmail());
                            System.out.println("Department: "+emp.getDepartment());
                            System.out.println("Salary: "+emp.getSalary());

                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Employee Id to search: ");
                    int searchid = readInt(sc);

                    boolean found = false;

                    for(Employee emp:employees){
                        if(emp.getId()==searchid){
                            System.out.println("\nEmployee Found.");
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Email: " + emp.getEmail());
                            System.out.println("Department: " + emp.getDepartment());
                            System.out.println("Salary: " + emp.getSalary());

                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter employee id to Update: ");
                    int updateid = readInt(sc);
                    sc.nextLine();

                    boolean found1 = false;

                    for(Employee emp : employees) {
                        if (emp.getId() == updateid) {

                            String newName;
                            while (true) {
                                System.out.print("Enter new name: ");
                                newName = sc.nextLine().trim();

                                if (!newName.isEmpty() && newName.matches("[a-zA-Z ]+")) {
                                    break;
                                }

                                System.out.println( "Invalid name! Use letters and spaces only." );
                            }

                            String newEmail;
                            while(true){
                                System.out.println("Enter new Email: ");
                                newEmail = sc.nextLine().trim();

                                if(newEmail.matches( "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")){
                                    break;
                                }

                                System.out.println("Invalid Email ! Please Enter a valid Email");
                            }

                            String newDepartment;
                            while(true){
                                System.out.println("Enter new Department: ");
                                newDepartment = sc.nextLine().trim();

                                if(!newDepartment.isEmpty() && newDepartment.matches("[a-zA-Z]+")){
                                    break;
                                }

                                System.out.println("Invalid department! Use letters and spaces only.");
                            }

                            System.out.println("Enter new Salary: ");
                            Double newsalary = readDouble(sc);

                            emp.setName(newName);
                            emp.setEmail(newEmail);
                            emp.setDepartment(newDepartment);
                            emp.setSalary(newsalary);

                            System.out.println("Employee update successfully!");

                            found1 = true;
                            break;
                        }
                    }

                        if(!found1){
                                System.out.println("Employee not found!");
                            }
                        break;

                case 5:
                    System.out.println("Enter Employee id to delete: ");
                    int deleteId = readInt(sc);

                    boolean found2 = false;

                    for(Employee emp : employees){
                        if(emp.getId()==deleteId) {
                            employees.remove(emp);

                            found2 = true;
                            System.out.println("Employee deleted successfully!");
                            break;
                        }
                    }

                    if(!found2){
                        System.out.println("Employee not found !");
                    }
                    break;

                case 6:
                    System.out.println("Enter Department");
                    String searchdepartment = sc.nextLine();

                    boolean found3 = false;

                    for(Employee emp : employees){
                        if(emp.getDepartment().equalsIgnoreCase(searchdepartment)){
                            System.out.println("\nEmployee Found");
                            System.out.println("ID: " + emp.getId());
                            System.out.println("Name: " + emp.getName());
                            System.out.println("Email: " + emp.getEmail());
                            System.out.println("Department: " + emp.getDepartment());
                            System.out.println("Salary: " + emp.getSalary());

                            found3 = true;
                        }
                    }

                    if(!found3){
                        System.out.println("no employee found in this department !");
                    }
                    break;


                case 7:

                    if (employees.isEmpty()) {
                        System.out.println("No employees found!");
                        break;
                    }

                    employees.sort((e1, e2) ->
                            Double.compare(e2.getSalary(), e1.getSalary())
                    );

                    System.out.println("Employees sorted by salary!");

                    for (Employee emp : employees) {
                        System.out.println(
                                "ID: " + emp.getId()
                                        + ", Name: " + emp.getName()
                                        + ", Department: " + emp.getDepartment()
                                        + ", Salary: " + emp.getSalary()
                        );
                    }

                    break;

                case 8:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
