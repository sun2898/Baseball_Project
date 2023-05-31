package project01;

public class PlayersVO {

   private int p_code;
   private String p_name;
   private String p_position;
   private int height;
   private int score;
   private int join_year;
   private double serve;
   private double blocking;
   private double receive;
   private double p_set;
   private String team_name;
   
   public PlayersVO() {}
   
   public PlayersVO(int p_code) {
      super();
      this.p_code = p_code;
   }
   
   public PlayersVO(int p_code, int score, double serve, double blocking, double receive,
          double p_set, String team_name ) {
      super();
      this.p_code = p_code;
      this.score = score;
      this.serve = serve;
      this.blocking = blocking;
      this.receive = receive;
      this.p_set = p_set;
      this.team_name = team_name;
   }
   
   public PlayersVO(int p_code, String p_name, String p_position, int height, int score, int join_year, double serve,
         double blocking, double receive, double p_set, String team_name) {
      super();
      this.p_code = p_code;
      this.p_name = p_name;
      this.p_position = p_position;
      this.height = height;
      this.score = score;
      this.join_year = join_year;
      this.serve = serve;
      this.blocking = blocking;
      this.receive = receive;
      this.p_set = p_set;
      this.team_name = team_name;
   }

   public int getP_code() {
      return p_code;
   }

   public void setP_code(int p_code) {
      this.p_code = p_code;
   }

   public String getP_name() {
      return p_name;
   }

   public void setP_name(String p_name) {
      this.p_name = p_name;
   }

   public String getP_position() {
      return p_position;
   }

   public void setP_position(String p_position) {
      this.p_position = p_position;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public int getScore() {
      return score;
   }

   public void setScore(int score) {
      this.score = score;
   }

   public int getJoin_year() {
      return join_year;
   }

   public void setJoin_year(int join_year) {
      this.join_year = join_year;
   }

   public double getServe() {
      return serve;
   }

   public void setServe(double serve) {
      this.serve = serve;
   }

   public double getBlocking() {
      return blocking;
   }

   public void setBlocking(double blocking) {
      this.blocking = blocking;
   }

   public double getReceive() {
      return receive;
   }

   public void setReceive(double receive) {
      this.receive = receive;
   }

   public double getP_set() {
      return p_set;
   }

   public void setP_set(double p_set) {
      this.p_set = p_set;
   }

   public String getTeam_name() {
      return team_name;
   }

   public void setTeam_name(String team_name) {
      this.team_name = team_name;
   }
   
   
   
}