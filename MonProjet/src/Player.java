public  class Player {
    
    private static String name;
    private String role;

    public Player(String name, String role) {
        Player.name = name;
        this.role = role;
    }

    public static String getName() {
        return name;
    }
              
    public void setName(String name) {
        Player.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
   
}
