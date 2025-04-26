
 class HorseTest {
    public static void main(String[] args) {
        Horse horse = new Horse('♘', "PIPPI LONGSTOCKING", 0.3);
        System.out.println(horse.getSymbol());
        System.out.println(horse.getName());
        horse.moveForward();
        System.out.println(horse.getDistanceTravelled());
        horse.fall();
        System.out.println(horse.getConfidence());
        System.out.println(horse.hasFallen());
    }
}