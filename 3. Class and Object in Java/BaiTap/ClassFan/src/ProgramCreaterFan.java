public class ProgramCreaterFan {
    public static void main(String[] args) {
        System.out.println("Tạo cánh quạt từ Class cho trước");
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(10,"Yellow","SenKo",5,true);
        Fan fan3 = new Fan(5,"Blue","DaiKin",1,false);
        System.out.println(fan1.information());
        System.out.println(fan2.information());
        System.out.println(fan3.information());
    }
}
