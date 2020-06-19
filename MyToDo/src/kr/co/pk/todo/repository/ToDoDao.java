package kr.co.pk.todo.repository;

public class ToDoDao {
	//싱글톤 패턴으로 만들기 위한 코드
	//서버를 생성하는 프레임워크에서는 아래 코드를 프레임워크가 삽입
   private ToDoDao() {}
   private static ToDoDao toDoDao;
   public static ToDoDao sharedInstance() {
	   if(toDoDao == null) {
		   toDoDao = new ToDoDao();
	   }
	   return toDoDao;
   }
   public void create() {
	   System.out.println("DAO 에서 데이터 저장");
   }
   public void read() {
	   System.out.println("DAO 에서 데이터 가져오기");
   }
   public void update() {
	   System.out.println("DAO 에서 데이터 수정");
   }
   public void delete() {
	   System.out.println("DAO 에서 데이터 삭제");
   }
}
