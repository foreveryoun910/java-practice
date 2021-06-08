package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {

	// 매번 써야하는 꼭 필요한 기능들은 필드로 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;

	// 연결메소드
	public static void connect() {
		conn = null; // 연결객체
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결성공!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// connect 닫는 함수
	public static void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if

		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end of if
	} // end of close

	// 1.전체조회
	public static ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<Person>();
		connect();
		String sql = "select * from person";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));

				personList.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;

	}

	// 2.입력
	public static void insertPerson(int id, String name, int age, String phone) {
		connect();
		String sql = "insert into person values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);

			int r = psmt.executeUpdate();

			System.out.println(r + "건 입력했습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 3.수정
	public static void updatePerson(Person person) {
		connect();
		String sql = "update person set name=?, age=?, phone=? where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, person.getName());
			psmt.setInt(2, person.getAge());
			psmt.setString(3, person.getPhone());
			psmt.setInt(4, person.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경했습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	// 4.삭제
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from person where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제했습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	// 5.한건조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from person where id=?";
		Person p = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				p = new Person();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return p;

	}

	// 6.이름으로 조회
	public static ArrayList<Person> getNamePerson() {
		connect();
		String sql = "select * from person";
		ArrayList<Person> personList = new ArrayList<Person>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Person p = new Person();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone"));

				personList.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1: 전체리스트 | 2: 입력 | 3: 수정 | 4: 삭제 | 5: 한건조회 | 6: 이름으로 조회 | 9: 종료");
			int menu = scanner.nextInt();
			scanner.nextLine();

			if (menu == 1) {
				ArrayList<Person> list = getPersonList();
				System.out.println("[조회 결과]");
				for (Person person : list) {
					System.out.println(person);
				}
			}

			else if (menu == 2) {
				System.out.print("아이디를 입력하세요> ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("이름을 입력하세요> ");
				String name = scanner.nextLine();
				System.out.print("나이를 입력하세요> ");
				int age = scanner.nextInt();
				scanner.nextLine();
				System.out.print("전화번호를 입력하세요> ");
				String phone = scanner.nextLine();

				insertPerson(id, name, age, phone);
			}

			else if (menu == 3) {
				System.out.print("조회할 아이디를 입력하세요> ");
				int id = scanner.nextInt();
				scanner.nextLine();

				Person p = getPerson(id); // p는 한건조회 메소드에서 id만 검색한 것을 저장 -> 해당 id의 데이터
				if (p == null) {
					System.out.println("존재하지 않는 아이디입니다");
					continue;
				}

				System.out.print("변경할 이름을 입력하세요> ");
				String changedName = scanner.nextLine();
				System.out.print("변경할 나이를 입력하세요> ");
				String changedAge = scanner.nextLine();
				System.out.print("변경할 전화번호를 입력하세요> ");
				String changedPhone = scanner.nextLine();

				if (!changedName.equals("")) {
					p.setName(changedName);
				}
				if (!changedAge.equals("")) {
					p.setAge(Integer.parseInt(changedAge));
				}
				if (!changedPhone.equals("")) {
					p.setPhone(changedPhone);
				}

				updatePerson(p);
			}

			else if (menu == 4) {
				System.out.print("아이디를 입력하세요> ");
				int id = scanner.nextInt();

				deletePerson(id);
			}

			else if (menu == 5) {
				System.out.print("조회할 아이디를 입력하세요> ");
				int id = scanner.nextInt();

				Person p = getPerson(id);

				if (p == null) {
					System.out.println("존재하지 않는 아이디입니다");
				} else {
					System.out.println(p);
				}
			}

			else if (menu == 6) {
				System.out.print("조회할 이름를 입력하세요> ");
				String name = scanner.nextLine();

				ArrayList<Person> personList = getNamePerson();
				// 전체 목록에서
				// 입력한 이름이 배열 요소중에 없으면 존재하지 않는 이름입니다. 출력
				
				for(int i=0; i<personList.size(); i++) {
					if (personList.contains(name) == false) {
						System.out.println("존재하지 않는 이름입니다.");
					}					
				}

				// 목록 도는동안 이름이 입력한 이름이랑 같은 요소를 출력
				for (Person p : personList) {
					if (p.getName().equals(name)) {
						System.out.println(p);
					}
				} // end of for
			}

			else if (menu == 9) {
				break;
			}
		}

		System.out.println("정상적인 종료");
		scanner.close();
	} // end of main
} // end of class
