//package proxy;

interface DatabaseExecuter {
	public void executeDatabase(String query) throws Exception;
}

class DatabaseExecuterImp implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute query : "+query);
	}
}


class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean isAdmin;
	DatabaseExecuterImp dbExecuter;
	
	public DatabaseExecuterProxy(String user, String pass) {
		if(user == "admin" && pass == "test@123") {
			isAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImp();
	}
	
	@Override
	public void executeDatabase(String query) throws Exception {
		if(isAdmin == true)
			dbExecuter.executeDatabase(query);
		else if(query.equals("DELETE"))
			throw new Exception("Only admins can perform delete operation");
		else
			dbExecuter.executeDatabase(query);
	}
}


public class ProxyPatternSample {
	public static void main(String[] args) {
		DatabaseExecuter nonAdmin = new DatabaseExecuterProxy("nonAdmin", "password");
		try {
			nonAdmin.executeDatabase("UPDATE table");
			nonAdmin.executeDatabase("DELETE");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		DatabaseExecuter admin = new DatabaseExecuterProxy("admin", "password");
		try {
			admin.executeDatabase("UPDATE table");
			admin.executeDatabase("DELETE table");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
