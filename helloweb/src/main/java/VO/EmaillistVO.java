package VO;



public class EmaillistVO {
	private Integer no;
    private String first_name;
    private String last_name;
    private String email;
    
  

	private EmaillistVO(Builder builder){
        this.no=builder.no;
        this.first_name=builder.first_name;
        this.last_name=builder.last_name;
        this.email=builder.email;
  
    }

    public Integer getNo() {
		return no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getEmail() {
		return email;
	}

	public static Builder Builder(){
        return new Builder();
    } 

    public static class Builder{
    	private Integer no;
        private String first_name;
        private String last_name;
        private String email;
	    
        public Builder(){
            this.first_name="없음";
            this.last_name="없음";
        }
        
     
        public Builder no(Integer no){
            this.no = no;
            return this;
        }
        public Builder first_name(String first_name){
            this.first_name = first_name;
            return this;
        }
        public Builder last_name(String last_name){
            this.last_name = last_name;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
    
        
        public EmaillistVO build(){
            return new EmaillistVO(this);
        }
    }
}
