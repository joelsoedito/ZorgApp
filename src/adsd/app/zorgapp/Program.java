package adsd.app.zorgapp;

public class Program {

    private static ZorgApp zorgapp;

    //todo Move Login Menu to ProgramClass

    public static void main(String[] args) {
        zorgapp = new ZorgApp();
        zorgapp.Login();
    }
}

