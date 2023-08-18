package tennis;

public class MatchScore {
	
	 private int points;
	    private int games;
	    private int sets;
	    private int matches;

	    public MatchScore() {
	        this.points = 0;
	        this.games = 0;
	        this.sets = 0;
	        this.matches = 0;
	    }
	    
	    	
	    	public void updatePoints() {
	            if (points < 30) {
	                points += 15;
	            } else if (points == 30) {
	                points = 40;
	            } else if (points == 40) {
	                points = 0;
	                updateGames();
	            }
	        
	    }
	         public void updateGames() {
	    		  if(points==50) {
	    			  updatePoints();
	 
	    		  }else {
	    			  games++;
	    			  resetPoints();
	    		  }
	    	    }

	    	    public void resetGames() {
	    	        games = 0;
	    	    }

	    	    public void updateSets() {
	    	        sets++;
	    	        resetGames();
	    	    }

	    	    public void resetSets() {
	    	        sets = 0;
	    	        resetGames();
	    	    }
	    	    private void handleDeuceAndAdvantage() {
	    	    	points=50;}
	    	    

	    	    public void updateMatches() {
	    	        matches++;
	    	    }
	    	    public void resetPoints() {
	    			points=0;
	    			
	    		}

	    		public int getPoints() {
	    			return points;
	    		}

	    		public int getSets() {
	    			return sets;
	    		}

	    		public int getGames() {
	    			return games;
	    		}
	    		public int getMatches() {
	    			return matches;
	    		}
	    


	    @Override
	    public String toString() {
	        return matches + " matches, " + sets + " sets, " + games + " games, " + points + " points";
	    }




	}

