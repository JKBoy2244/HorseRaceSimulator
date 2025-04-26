
class Horse {

  private String horseName; //These variables are encapsulated as they are private as they're only available to the horse class itself and not the race class. So these variables shouldn't be exposed by the race class. These variables are private to make the code much more secure and protected and they describe the statistics of the horse.
  private char horseSymbol; 
  private int horseDistance;
  private boolean horseFallen;
  private double horseConfidence;

  public Horse(char horseSymbol, String horseName, double horseConfidence) {

    if (horseConfidence < 0.00 || horseConfidence > 1.00) {
      throw new IllegalArgumentException("Confidence rating is invalid outside of range!!!");
    }

    if (horseName == null || horseName.isEmpty()) {
      throw new IllegalArgumentException("Horse name can't be empty!!!");
    }
 
    this.horseName = horseName;
    this.horseSymbol = horseSymbol;
    this.horseDistance = 0;
    this.horseFallen = false;
    this.horseConfidence = horseConfidence;
  }

  public double getConfidence() {
    return horseConfidence;
  }

  public int getDistanceTravelled() {
    return horseDistance;
  }

  public String getName() {
    return horseName;
  }

  public char getSymbol() {
    return horseSymbol;
  }

  public void setConfidence(double newConfidence) {

   if (newConfidence < 0.00 || newConfidence > 1.00) {
      throw new IllegalArgumentException("Confidence rating is invalid outside of range!!!");
    }
    this.horseConfidence = newConfidence;
  }

  public void setSymbol(char newSymbol) {
    this.horseSymbol = newSymbol;
  }

  public void moveForward() {
     this.horseDistance++;
  }  

  public void fall() {
    this.horseFallen = true;
  }

  public void goBackToStart() {
    horseDistance = 0;
    horseFallen = false;
  }

  public boolean hasFallen() {
      return horseFallen;
    }
  }



