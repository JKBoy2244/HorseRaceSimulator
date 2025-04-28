import javax.swing.*;
import java.util.List;

public class RaceStatistics {

  public static void displayStats(List<Horse> horses, Horse horseWinner, long timeStart, long timeEnd, int trackLength) {

    double raceDuration = (timeEnd - timeStart)/1000.0;
    double raceMinutes = raceDuration / 60.0;

    int finished = 0;
    int fallen = 0;
    double updateConfidence = 0.0;

    for (Horse horse : horses) {
        if (horse.hasFallen()) {
            fallen++;
        } else if (horse.getDistanceTravelled() >= trackLength) {
            finished++;
        }
        updateConfidence += horse.getConfidence();
    }

    double averageConfidence = horses.isEmpty() ? 0.0 : updateConfidence / horses.size();

    
          StringBuilder message = new StringBuilder();
          message.append("Race duration in seconds: ").append(raceDuration).append("\n");
          message.append("Race duration in minutes: ").append(raceMinutes).append("\n");
          message.append("Updated confidence: ").append(updateConfidence).append("\n");
          message.append("Number of horses fallen: ").append(fallen).append("\n");
          message.append("Number of horses finished: ").append(finished);
         message.append("📈 Average Confidence: ").append(String.format("%.2f", averageConfidence)).append("\n");
         message.append("Winner: ").append(horseWinner != null ? horseWinner.getName() : "No Winner").append("\n");

      JOptionPane.showMessageDialog(null, message.toString(), "Race Statistics", JOptionPane.INFORMATION_MESSAGE);
        }
      }