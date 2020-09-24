public class Mensch extends Aerger {


  public static void main(String[] args) { 

    // Ausgangsposition
    int[] arrYellow = {-1, -1, -1, -1};
    int[] arrBlue = {-1, -1,-1, -1};
    int[] arrGreen = {-1, -1, -1, -1};
    int[] arrRed = {-1, -1, -1, -1};

    paintField(arrYellow, arrBlue, arrGreen, arrRed);


    write("Spieler Gelb fängt an:");
    int yellow = 1;
    int blue = 0;
    boolean korrekt = false;
    while (!korrekt) { // einer hat gewonnen
      if (arrYellow[0] >= 40 && arrYellow[1] >= 40 && arrYellow[2] >= 40 && arrYellow[3] >= 40
          || arrBlue[0] >= 40 && arrBlue[1] >= 40 && arrBlue[2] >= 40 && arrBlue[3] >= 40) {

        korrekt = true;
      } else { // es hat noch niemand gewonnen

        if (yellow > blue) {

          if (arrYellow[0] < 40 || arrYellow[1] < 40 || arrYellow[2] < 40 || arrYellow[3] < 40) {
            int wurf1 = dice();
            write("Der Spieler Gelb ist dran und hat " + wurf1 + " gewürfelt.");
            int y = readInt("Welchen Spieler möchtest du bewegen. Wähle zwischen 1-4 aus:");
            while (y <= 0 || y >= 5) {
              y = readInt("Es muss eine Zahl zwischen 1 und 4 sein!");
            }
            while (arrYellow[y - 1] > 39) {
              y = readInt(
                  "Dieser Spieler steht schon im Garten. Bitte wähle einen anderen Spieler aus.");
            }
            int z = arrYellow[y - 1]; // Hilfsvariable
            if (arrYellow[y - 1] < 0) { // aus Häuschen hüpfen
              arrYellow[y - 1] += (wurf1 + 1);
            } else { // normal hüpfen
              arrYellow[y - 1] += (wurf1);
            }
            for (int i = 0; i < 4; i++) { // checken, ob ein Spieler von Gelb blockiert
              if (arrYellow[i] == (arrYellow[y - 1]) && i != y - 1 && arrYellow[i] <= 39) {
                arrYellow[y - 1] = z;
                y = readInt(
                    "Auf diesem Feld steht bereits einer deiner Spieler. Wähle einen anderen!");
                while (y <= 0 || y >= 5) {
                  y = readInt("Es muss eine Zahl zwischen 1 und 4 sein!");
                }
                while (arrYellow[y - 1] > 39) {
                  y = readInt(
                      "Dieser Spieler steht schon im Garten. Bitte wähle einen anderen Spieler aus.");
                }
                if (arrYellow[y - 1] < 0) { // zweiter Versuch: hüpfen aus Häuschen
                  arrYellow[y - 1] += (wurf1 + 1);
                } else { // zweiter Versuch: normal hüpfen
                  arrYellow[y - 1] += (wurf1);
                }
                i = 0;
              }
            }
            for (int i = 0; i < 4; i++) { // Spieler von Blau rauskicken
              if (arrBlue[i] == arrYellow[y - 1] && arrYellow[y - 1] <= 39) {
                arrBlue[i] = -1;
                write("Der Spieler von Blau wurde wieder zurück ins Häuschen geschubst.");
              }
            }
            paintField(arrYellow, arrBlue, arrGreen, arrRed);
            yellow = 0; // Spielerwechsel
            blue = 1;
          }
        }


        if (blue > yellow) {

          if (arrBlue[0] < 40 || arrBlue[1] < 40 || arrBlue[2] < 40 || arrBlue[3] < 40) {
            int wurf1 = dice();
            write("Der Spieler Blau ist dran und hat " + wurf1 + " gewürfelt.");
            int y = readInt("Welchen Spieler möchtest du bewegen. Wähle zwischen 1-4 aus:");
            while (y <= 0 || y >= 5) {
              y = readInt("Es muss eine Zahl zwischen 1 und 4 sein!");
            }
            while (arrBlue[y - 1] > 39) {
              y = readInt(
                  "Dieser Spieler steht schon im Garten. Bitte wähle einen anderen Spieler aus.");
            }
            int z = arrBlue[y - 1]; // Hilfsvariable
            if (arrBlue[y - 1] < 0) {
              arrBlue[y - 1] += (wurf1 + 11); // aus Häuschen hüpfen
            } else { // normal hüpfen
              if (arrBlue[y - 1] >= 0 && arrBlue[y - 1] <= 9) {
                arrBlue[y - 1] += (wurf1);
                if (arrBlue[y - 1] >= 10) {
                  arrBlue[y - 1] += 30;
                }
              }
              if (arrBlue[y - 1] < 40 && arrBlue[y - 1] > 10) {
                arrBlue[y - 1] += (wurf1);
                if (arrBlue[y - 1] >= 40 && arrBlue[y - 1] <= 46) {
                  arrBlue[y - 1] = arrBlue[y - 1] - 40;
                }
              }
            }

            for (int i = 0; i < 4; i++) { // checken ob Spieler derselben Farbe das Feld blockiert
              if (arrBlue[i] == (arrBlue[y - 1]) && i != y - 1 && arrBlue[i] <= 39) {
                arrBlue[y - 1] = z;
                y = readInt(
                    "Auf diesem Feld steht bereits einer deiner Spieler. Wähle einen anderen!");
                while (y <= 0 || y >= 5) {
                  y = readInt("Es muss eine Zahl zwischen 1 und 4 sein!");
                }
                while (arrBlue[y - 1] > 39) {
                  y = readInt(
                      "Dieser Spieler steht schon im Garten. Bitte wähle einen anderen Spieler aus.");
                }
                if (arrBlue[y - 1] < 0) {
                  arrBlue[y - 1] += (wurf1 + 11);// aus Höuschen hüpfen
                } else { // normal hüpfen
                  if (arrBlue[y - 1] >= 0 && arrBlue[y - 1] <= 9) {
                    arrBlue[y - 1] += (wurf1);
                    if (arrBlue[y - 1] >= 10) {
                      arrBlue[y - 1] += 30;
                    }
                  }
                  if (arrBlue[y - 1] < 40 && arrBlue[y - 1] > 10) {
                    arrBlue[y - 1] += (wurf1);
                    if (arrBlue[y - 1] >= 40 && arrBlue[y - 1] <= 46) {
                      arrBlue[y - 1] = arrBlue[y - 1] - 40;
                    }
                  }
                }
                i = 0;
              }
            }
            for (int i = 0; i < 4; i++) { // Spieler von Gelb rauskicken
              if (arrYellow[i] == arrBlue[y - 1] && arrBlue[y - 1] <= 39) {
                arrYellow[i] = -1;
                write("Der Spieler von Gelb wurde wieder zurück ins Häuschen geschubst.");
              }
            }
            blue = 0; // Spielerwechsel
            yellow = 1;
            paintField(arrYellow, arrBlue, arrGreen, arrRed);
          }
        }
      }
    } // Gewinner ermitteln
    if (arrYellow[0] >= 40 && arrYellow[1] >= 40 && arrYellow[2] >= 40 && arrYellow[3] >= 40) {
      write("Der Spieler Gelb hat gewonnen!");
    }
    if (arrBlue[0] >= 40 && arrBlue[1] >= 40 && arrBlue[2] >= 40 && arrBlue[3] >= 40) {
      write("Der Spieler Blau hat gewonnen!");
    }
  }
}


