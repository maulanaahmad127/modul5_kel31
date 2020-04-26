

package modul5_kel31;

import java.util.Scanner;

public class userService {
    private String[][] data = new String[2][3];
    private String[][] histories = new String[2][6];
    private String email, password, roles = "";
    int hari;
    public userService(String emails, String passwords)
    {
        email = emails;
        password = passwords;
        String[][] data = 
        { 
            {"maul@gmail.com", "12345", "supedAdmin"},
            {"peggy@gmail.com", "12345", "user"} 
        };
        String[][] histories =
        {
            {"maul@gmail.com", "senin", "selasa", "rabu", "kamis", "jum'at","26-04-2020"},
            {"peggy@gmail.com", "senin", "selasa", "rabu", "kamis", "jum'at","26-04-2020"}
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
                    if(data[i][0] == histories[i][0])
                        hari = i;
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
            
            System.out.println("Telah menghadiri kuliah " + email + " pada hari = " );
            for (int i=1; i <= 5; i++){
                System.out.println(histories[hari][i]);
            }
            System.out.println("Tercatat pada tanggal : " + histories[hari][6]);
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

   