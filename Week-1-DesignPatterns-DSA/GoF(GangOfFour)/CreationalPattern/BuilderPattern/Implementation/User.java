public class User {

    private String username;
    private String email;
    private String bio;
    private String location;

    public String getUsername(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }
    public String getBio(){
        return this.bio;
    }
    public String getLocation(){
        return this.location;
    }
    
    public User(Builder build){
        this.username = build.username;
        this.email = build.email;
        this.bio  = build.bio;
        this.location = build.location;
    }

    public static class Builder{
        private String username;
        private String email;
        private String bio;
        private String location;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder bio(String bio){
            this.bio = bio;
            return this;
        }

        public Builder location(String location){
            this.location = location;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }    
}
