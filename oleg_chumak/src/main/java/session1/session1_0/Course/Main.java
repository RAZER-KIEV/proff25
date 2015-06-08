package session1.session1_0.Course;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException, GroupExistsException, NoSuchStudentException, NoSuchGroupException, NoSuchCourseException {
//		TreeSet<Student> st = new TreeSet();
//
//		Student s = new Student("ff");
//		Student t = new Student("gsdf");
//		Student e = new Student("dfgsf");
//		Student a = new Student("dfgdfd");
//		Student q = new Student("dsgdf");
//		st.add(s);
//		st.add(e);
//		st.add(t);
//		st.add(a);
//		st.add(q);
////		gr.add(new Student(""));
//		Group gr = new Group("gr", st);
//		System.out.println(gr);

//	Course c = new Course("dfs", "startData");
//	c.themes.add("sdf");
//	c.themes.add("sfsdf");
//	System.out.println(c.themes);
//
//		Manager man = new Manager();
//		man.serialize();
//		man.deserialize();
//		Manager man = new Manager();
//		man.addGroup("grrr1");
//		man.addGroup("grrr3");
//		Student st1 = new Student("Petya");
//		Student st2 = new Student("Vasya");
//		Student st3 = new Student("Lena");
//		Student st5 = new Student("Anya");
//		man.addStudent(st1);
//		man.addStudent(st2);
//		man.addStudent(st3);
//		man.addStudent(st5);
//		man.addStudentToGroup("Petya", "grrr1");
//		man.addStudentToGroup("Vasya", "grrr1");
//		man.cloneGroup("grrr3", "grrr4");
//		man.addStudentToGroup("Lena", "grrr3");
//		man.addStudentToGroup("Anya", "grrr3");
////		man.printGroupInfo("grrr1");
//		man.setGroupName("grrr1", "grrr2");
//		man.serialize();
////		man.deserialize();
//		ArrayList<String> themes = new ArrayList<>();
//		themes.add("theme 1");
//		themes.add("theme 2");
//		Course cr1 = new Course("cur", "11.05");
//		Course cr2 = new Course("cur2", "54.36");
//		man.addCourse(cr1);
//		man.addCourse(cr2);
////		System.out.println(man.getCourse("cur").getName());
//		man.addGroupToCourse("grrr2", "cur");
//		man.addGroupToCourse("grrr3", "cur2");
//		man.addGroupToCourse("grrr2", "cur2");
//		man.setThemes("cur", themes);
////		man.printCourses();
//		ArrayList<String> studs = new ArrayList<String>();
//		studs.add("Petya");
//		man.removeStudentFromGroup("Anya", "grrr3");
//		man.removeGroupsFromCourseByStudents("cur2", studs);
//		man.printCourses();
//		man.printGroupInfo("grrr4");
        Display d = new Display();
        d.mainMenu();
    }
}



class Course implements Comparable{
    private String name;
    String startData;
    List<String> themes = new ArrayList<>();
    TreeSet<Group> groupes = new TreeSet<>();

    public Course(String name, String startData){
        this.name = name;
        this.startData = startData;
    }

    public Course (String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Object o) {
        Course tmp = (Course)o;
        return name.compareTo(tmp.name);
    }

    public Course addCourse(String name, String startData){
        return new Course(name, startData);
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){StringBuilder sb = new StringBuilder();
        for(Group gr : groupes){
            sb.append(gr.toString()).append("\n");
        }
        if(themes.size() != 0){
            sb.append("Temes: " +themes.toString()+ "\n");
        }
        return "Курс: " +name+ " \n \n" +sb.toString();

    }


    void removeGroup(Group gr){
        groupes.remove(gr);
    }

    public Group findGroup(String gr) throws NoSuchGroupException{
        for(Group group : groupes){
            if(group.getName().equals(gr)){
                return group;
            }
        }
        throw new NoSuchGroupException();
    }
}


class Display {
    boolean isStarted = false;
    Manager man = new Manager();
    public  void mainMenu(){
        if(!isStarted){
            System.out.println("Добро пожаловать в меню управления курсами!");
        }
        System.out.println("Выберите одну из следующих опций");
        System.out.println("[1]  Добавить студента на курсы");
        System.out.println("[2]  Добавить группу по имени");
        System.out.println("[3]  Задать новое имя группы");
        System.out.println("[4]  Вывести информацию о группе");
        System.out.println("[5]  Добавить студента в группу по фамилии");
        System.out.println("[6]  Удалить студента из группы по фамилии");
        System.out.println("[7]  Создать копию группы со студентами");
        System.out.println("[8]  Сохранить информацию о курсах в файл");
        System.out.println("[9]  Прочитать информацию о курсах из файла");
        System.out.println("[10] Добавить курс");
        System.out.println("[11] Добавить Группу в Курс по имени");
        System.out.println("[12] Задать темы курса");
        System.out.println("[13] Удалить из Курса группы, в которых учатся указанные студенты");
        System.out.println("[14] Выйти из системы");
        isStarted = true;
        try {
            scanMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanMain() throws IOException{
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch(tmp){
            case "1":
                one();
                break;
            case "2":
                two();
                break;
            case "3":
                three();
                break;
            case "4":
                four();
                break;
            case "5":
                five();
                break;
            case "6":
                six();
                break;
            case "7":
                seven();
                break;
            case "8":
                eight();
                break;
            case "9":
                nine();
                break;
            case "10":
                ten();
                break;
            case "11":
                eleven();
                break;
            case "12":
                twelve();
                break;
            case "13":
                thirteen();
                break;
            case "14":
                System.out.println("До новых встреч!");
                System.exit(0);
                break;
            default:
                System.out.println("Вы ввели некоректный символ, введите число от 1 до 14");
                scanMain();
                break;
        }
    }

    private void one(){
//		[1]  Добавить студента на курсы
        System.out.println("Введите фамилию студента, который будет добавлен на курсы");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        man.addStudent(new Student(tmp));
        System.out.println("Студент " +tmp+ " успешно добавлен\n\n");
        mainMenu();
    }

    private void two(){
//		[2]  Добавить группу по имени
        System.out.println("Введите имя группы, которая будет добавлена");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        try {
            man.addGroup(tmp);
            System.out.println("Группа "+tmp+" успешно добавлена\n\n");
            mainMenu();
        } catch (GroupExistsException e) {

            System.out.println("Такая группа уже существует");
            twoOut();
        }
    }

    private void twoOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                two();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                twoOut();
                break;
        }
    }

    private void three(){
//		Задать новое имя группы
        System.out.println("Введите имя группы, которую следует переименовать");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        System.out.println("Ведите новое имя для группы");
        String tmpn = scan.next();
        try {
            man.setGroupName(tmp, tmpn);
            System.out.println("Группа '" +tmp+  "' успешно переименована на '"+tmpn+ "'");
            mainMenu();
        } catch (NoSuchGroupException e) {
            System.out.println("Не существует той группы, которую Вы хотели переименовать");
            threeOut();
        }
    }

    private void threeOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                three();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                twoOut();
                break;
        }
    }

    private void four(){
//		[4]  Вывести информацию о группе
        System.out.println("Введите имя группы, информацию о которой следует вывести");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        try {
            man.printGroupInfo(tmp);
            mainMenu();
        } catch (NoSuchGroupException e) {
            System.out.println("Группы, имя которой вы ввели, не существует");
            fourOut();
        }
    }

    private void fourOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                four();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                fourOut();
                break;
        }
    }

    private void five(){
//		[5]  Добавить студента в группу по фамилии
        System.out.println("Для закрепления за определенной группой студента, уже зарегистрированого на курсах,1 введите фамилию такого студента");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        System.out.println("Введите имя группы, за которой этого студента необходимо закрепить");
        String tmpl = scan.next();
        try {
            man.addStudentToGroup(tmp, tmpl);
            System.out.println("Студент " +tmp+ " закреплен за группой " +tmpl+ ".");
            mainMenu();
        } catch (NoSuchStudentException e) {
            System.out.println("Указанный Вами студент на курсах не зарегистрирован");
            fiveOut();
        } catch (NoSuchGroupException e) {
            System.out.println("Указанная вами группа не существует");
            fiveOut();
        }
    }

    private void fiveOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                five();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                fiveOut();
                break;
        }
    }

    private void six(){
//		[6]  Удалить студента из группы по фамилии
        System.out.println("Введите фамилию студента, которого необходимо исключить из группы");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        System.out.println("Введите имя группы, из которой следует исключить студента");
        String tmpl = scan.next();
        try {
            man.removeStudentFromGroup(tmp, tmpl);
        } catch (NoSuchStudentException e) {
            System.out.println("В указанной группе нет такого студента");
            sixOut();
        } catch (NoSuchGroupException e) {
            System.out.println("Вы указали неверное имя группы");
            sixOut();
        }
        System.out.println("Студент " +tmp+ " исключен из группы " +tmpl+ ".");
        mainMenu();
    }

    private void sixOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                six();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                sixOut();
                break;
        }
    }

    private void seven(){
//		[7]  Создать копию группы со студентами
        System.out.println("Для копирования группы введите имя той группы, с которой будет сниматься копия");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        System.out.println("Введите название для группы-клона");
        String tmpl = scan.next();
        try {
            man.cloneGroup(tmp, tmpl);
            System.out.println("Создана группа " +tmpl+ ", копия группы " +tmp );
            mainMenu();
        } catch (NoSuchGroupException e) {
            System.out.println("Указанной Вам группы не существует");
            sevenOut();
        }
        System.out.println("Копирование группы " +tmp+ " завершено успешно. Имя копии :"+tmpl);
        mainMenu();
    }

    private void sevenOut(){

        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                seven();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                sevenOut();
                break;
        }
    }

    private void eight() throws IOException{
//		[8]  Сохранить информацию о курсах в файл;
        man.serialize();
        System.out.println("Информация успешно сохранена в файл.");
        mainMenu();
    }

    private void nine() throws IOException{
//		[9]  Прочитать информацию о курсах из файла
        man.deserialize();
        mainMenu();
    }

    private void ten(){
//		[10] Добавить курс
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя для нового курса");
        String tmp = scan.next();
        man.addCourse(new Course(tmp));
        System.out.println("Курс " +tmp+  " успешно добавлен");
        mainMenu();
    }

    private void eleven(){
//		[11] Добавить Группу в Курс по имени
        System.out.println("Введите имя группы, которую следует добавить на курсы");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        System.out.println("Введите нзвание курса, к которому будет привязаня группа");
        String tmpl = scan.next();
        try {
            man.addGroupToCourse(tmp, tmpl);
            System.out.println("Группа " +tmp+ " была привящана к курсу" +tmpl);
            mainMenu();
        } catch (NoSuchGroupException e) {
            System.out.println("Не существует указанной группы");
            elevenOut();
        } catch (NoSuchCourseException e) {
            System.out.println("Не существует указанных курсов");
            elevenOut();
        }
    }

    private void elevenOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                eleven();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                elevenOut();
                break;
        }
    }

    private void twelve(){
//		[12] Задать темы курса
        System.out.println("Введите имя курса, для которого будут задаваться темы");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        try {
            Course cr = man.getCourse(tmp);
        } catch (NoSuchCourseException e) {
            System.out.println("Нету такого курса, айда заново!");
            twelveOut();
        }
        ArrayList<String> th = new ArrayList<>();
        System.out.println("Введите темы для курса, одну за одной. Когда ввод будет окончен, введите слово ГОТОВО большими буквами киррилицы");
        th = addToArray(th);
        System.out.println("Таким образом, мы задаем темы для группы " +tmp+". Список тем:");
        System.out.println(th);
        System.out.println("Если данные введены верно, и Вы желаете продолжить - введите (1). \n  Если данные введены неверно, для повторного внесения информации выберите опцию (2).\n Для выхода в главное меню - введите (0)");
        String tmpl = scan.next();
        switch(tmpl){
            case "1":
                try {
                    man.setThemes(tmp, th);
                } catch (NoSuchCourseException e) {}
                System.out.println("Для курса " +tmp+  " внесены следующие темы" +th);
                mainMenu();
                break;
            case "2":
                twelve();
                break;
            case "0":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1), (2) или (0)");
                twelveOut();
                break;
        }
    }

    private ArrayList<String> addToArray(ArrayList list){
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        if(tmp.equals("ГОТОВО") == false){
            list.add(tmp);
            return addToArray(list);
        }
        else return list;
    }

    private void twelveOut(){

        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                twelve();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                twelveOut();
                break;
        }
    }

    private void thirteen(){
//		[13] Удалить из Курса группы, в которых учатся указанные студенты

        ArrayList<Group> list = new ArrayList<>();
        System.out.println("Введите название курса, из которого будут удалятся группы");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        try {
            Course cr = man.getCourse(tmp);
        } catch (NoSuchCourseException e) {
            System.out.println("Нету такого курса, айда заново!");
            thirteenOut();
        }
        ArrayList<String> th = new ArrayList<>();
        System.out.println("Введите фамилии студентов, по чьм фамилиям будут удалены группы, одну за одной. Когда ввод будет окончен, введите слово ГОТОВО большими буквами киррилицы");
        th = addToArray(th);
        System.out.println("Таким образом, мы удалаяем группы из курса " +tmp+" по фамилиям:");
        System.out.println(th);
        System.out.println("Если данные введены верно, и Вы желаете продолжить - введите (1). \n  Если данные введены неверно, для повторного внесения информации выберите опцию (2).\n Для выхода в главное меню - введите (0)");
        String tmpl = scan.next();
        switch(tmpl){
            case "1":
                try {
                    list = man.removeGroupsFromCourseByStudentsG(tmp, th);
                } catch (NoSuchCourseException e) {}
                System.out.println("Из курса " +tmp+  " удалены следующие группы" +list);
                mainMenu();
                break;
            case "2":
                twelve();
                break;
            case "0":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1), (2) или (0)");
                twelveOut();
                break;
        }

    }

    private void thirteenOut(){
        System.out.println("Для повторной попытки нажмите (1), для выхода в главное меню нажмите (2)");
        Scanner scan = new Scanner(System.in);
        String tmp = scan.next();
        switch (tmp) {
            case "1":
                thirteen();
                break;
            case "2":
                mainMenu();
                break;
            default:
                System.out.println("Неверный символ, ввдедите (1) или (2)");
                thirteenOut();
                break;
        }
    }

}

class Group implements Comparable{
    private String name;
    TreeSet<Student> students = new TreeSet<>();

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, TreeSet<Student> students){
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Student st : students){
            sb.append(st.toString()).append("\n");
        }
        return "Группа: " +name+ " \n" +sb.toString();
    }

    @Override
    public int compareTo(Object o){
        Group tmp = (Group) o;
        return name.compareTo(tmp.name);
    }

    public void setName(String name){
        this.name = name;
    }

    public Student getStudent(String name) throws NoSuchStudentException{
        for(Student st : students){
            if (st.getName().equals(name)){
                return st;
            }
        }
        throw  new NoSuchStudentException();
    }


    public String getName() {
        return name;
    }
}

class Student implements Comparable{
    private String name;
    boolean inGroup = false;
    ArrayList<Integer> marks = new ArrayList<>();
    public Student(String name) {
        this.name = name;
    }

    public void addMark(int mark){
        marks.add(mark);
    }

    @Override
    public String toString() {
        if (marks.size() == 0) {
            return name;
        }
        else return name + marks.toString();
    }

    public String getName(){
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Student tmp = (Student)o;
        return name.compareTo(tmp.name);
    }
}

class Manager {
    TreeSet<Group> groupes = new TreeSet<>();
    TreeSet<Student> students = new TreeSet<>();
    TreeSet<Course> courses = new TreeSet<>();

    void setGroupName(String groupOldName, String groupNewName) throws NoSuchGroupException{
        getGroup(groupOldName).setName(groupNewName);
//		- Задать новое имя группы (старое имя, новое имя), +
    }

    void addStudent(Student student){
        students.add(student);
        //		 - Добавить студента на курсы,  +
    }

    void addGroup(String groupName) throws GroupExistsException{
        if(groupes.add(new Group(groupName)) == false) throw  new GroupExistsException();
//		 - Добавить группу по имени,  +
    }

    void printGroupInfo(String groupName) throws NoSuchGroupException{
        System.out.println(getGroup(groupName).toString());
//		 - Вывести информацию о группе,    +
    }


    void addStudentToGroup(String studentSName, String groupName) throws NoSuchStudentException, NoSuchGroupException{
        getGroup(groupName).students.add(getStudent(studentSName));
//		 - Добавить студента в группу по фамилии,    +
    }


    void removeStudentFromGroup(String studentSName, String groupName) throws NoSuchStudentException, NoSuchGroupException{
        if(getGroup(groupName).students.remove(getStudent(studentSName)) == false){
            throw new NoSuchStudentException();
        }
//		 - Удалить студента из группы по фамилии (на курсах студент остается),
    }

    void cloneGroup(String groupName, String newName) throws NoSuchGroupException{
        groupes.add(new Group(newName, getGroup(groupName).students));
//		- Создать копию группы со студентами, 	+
    }

    void serialize() throws IOException{
//					+
        String sourse = toString();
        char buffer[] = new char[sourse.length()];
        sourse.getChars(0,sourse.length(), buffer, 0);
        try(FileWriter f = new FileWriter("text.txt")){
            for(int i = 0; i < buffer.length; i++){
                f.write(buffer[i]);
            }
        }
    }


    void deserialize() throws IOException{
//					+
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader("text.txt")){
            int c;
            while((c = fr.read()) >0){
                sb.append((char)c);
            }
        }
        System.out.println(sb.toString());
//		 - Сохранить информацию о курсах в файл,
//		 - Прочитать информацию о курсах из файла,
    }

    void addCourse(Course course){
        courses.add(course);      /*+*/
    }

    void addGroupToCourse(String groupName, String courseName) throws NoSuchGroupException, NoSuchCourseException{
        getCourse(courseName).groupes.add(getGroup(groupName));
//		 - Добавить Группу в Курс по имени, 			+
    }

    void setThemes(String courseName, List<String> themes) throws NoSuchCourseException{
        getCourse(courseName).themes.addAll(themes);
//		 - Задать темы курса,   +
    }

    ArrayList<Group> removeGroupsFromCourseByStudentsG(String courseName, List<String> studs) throws NoSuchCourseException{
        ArrayList<Group> list = new ArrayList<>();
        for(Group gr : groupes){
            for(Student st :students){
                Iterator<Student> iter = students.iterator();
                while(iter.hasNext()){
                    Student str = (Student) iter.next();
                    if(st.getName().equals(str.getName())){
                        list.add(gr);
                        getCourse(courseName).groupes.remove(gr);
                    }
                }
            }
        }
        return list;
//		 - Удалить из Курса группы, в которых учяться указанные студенты (по имени),   +
    }


    void removeGroupsFromCourseByStudents(String courseName, List<String> studs) throws NoSuchCourseException{
        removeGroupsFromCourseByStudentsG(courseName, studs);
    }

    void printCourses(){

        StringBuilder sb = new StringBuilder();
        for(Course cr : courses){
            sb.append(cr.toString()).append("\n");
        }
        System.out.println( "Courses: \n \n" +sb.toString());

//		 - Вывести все курсы на экран,   +
    }


    public Student getStudent(String name) throws NoSuchStudentException{
        for(Student st : students){
            if (st.getName().equals(name)){
                return st;
            }
        }
        throw  new NoSuchStudentException();
    }

    public Group getGroup(String name) throws NoSuchGroupException{
        for(Group gr : groupes){
            if (gr.getName().equals(name)){
                return gr;
            }
        }
        throw new NoSuchGroupException();
    }


    public Course getCourse(String name) throws NoSuchCourseException{
        for(Course cr : courses){
            if (cr.getName().equals(name)){
                return cr;
            }
        }
        throw new NoSuchCourseException();
    }


    private Student addStud(String name){
        return new Student("name");
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Group gr : groupes){
            sb.append(gr.toString()).append("\n");
        }
        for(Course cr : courses){
            sb.append(cr.toString()).append("\n");
        }
        return "Обучение:  \n" +sb.toString();
    }
}


class NoSuchCourseException extends Exception{

    @Override
    public String toString(){
        return "No Such Course!!!";
    }
}

class NoSuchGroupException extends Exception{

    @Override
    public String toString(){
        return "No Such Group!!!";
    }
}

class NoSuchStudentException extends Exception{

    public String toString(){
        return "No Such Student!!!";
    }

}

class GroupExistsException extends Exception{

    public String toString(){
        return "Group Allready Exists!!!";

    }
}
