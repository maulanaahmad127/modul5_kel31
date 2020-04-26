package modul5_kel31;
import java.util.Scanner;


public class userService {
	private String[][] data = new String[2][3];
    private String[][] histories = new String[2][4];
    private String email, password, roles = "";
    int pinjaman;
    
    public userService(String emails, String passwords)
    {
        email = emails;
        password = passwords;
        String[][] data = 
        { 
            {"maul@gmail.com", "12345", "superAdmin"},
            {"peggy@gmail.com", "12345", "user"} 
        };
        String[][] histories =
        {
            {"maul@gmail.com","Fisika Dasar","Dasar Komputer dan Pemrograman","26-04-2020"},
            {"peggy@gmail.com","Dasar Komputer dan Pemrograman","Konsep Jaringan Komputer","26-04-2020"}
        };
        this.data = data;
        this.histories = histories;
    }
    
    private boolean checkCredential()
    {
        for(int i = 0; i < data.length; i++ )
        {
            if(data[i][0].equals(email))
            {
                if(data[i][1].equals(password))
                {
                    if (data[i][0] == histories[i][0])
                        pinjaman = i;
                    roles = data[i][2];
                    return true;
                }
            }
        }
        return false;
    }
    
    public void login()
    {
        boolean status = checkCredential();
        if(status == true)
        {
            System.out.println("\nWelcome " + roles);
            System.out.println("Logged it as user email " + email);
            System.out.println(email + " meminjam buku : ");
            for (int i=1; i<3; i++){
                System.out.println(histories[pinjaman][i]);
            }
            System.out.println("Tanggal Pinjaman : " + histories[pinjaman][3]);
        }
        else
        {
            System.out.println("\nInvalid Login ");
        }
    }

	public static void main(String[] args) {
		String email, password;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Email : ");
        email = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        
        userService display = new userService( email, password );
        display.login();
	}
}
