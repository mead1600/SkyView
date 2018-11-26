public class SkyView {
    private double[][] view;

    public SkyView(int numRows, int numCols, double[] scanned){
        int i = 0;
        int a = 0;
        for(int b = 0; b < scanned.length; b++){
            while(a < numRows){
                while(i < numCols){
                    view[a][i] = scanned[b];
                    i++;
                    a++;
                }
                while(i > 0){
                    view[a][i] = scanned[b];
                    i--;
                    a++;
                }
            }
        }
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol){
        int currentCol = startCol;
        int currentRow = startRow;
        int totalNum = 0;
        double sum = 0;
        if(startCol < endCol){
            while(currentCol < endCol){
                if(currentRow < endRow){
                    sum = sum + this.view[currentCol][currentRow];
                    currentCol++;
                    currentRow++;
                }
                else if(currentRow > endRow){
                    sum = sum + this.view[currentCol][currentRow];
                    currentCol++;
                    currentRow--;
                }
                totalNum = totalNum + 1;
            }
        }
        else if(startCol > endCol){
            while(currentCol > endCol){
                if(currentRow < endRow){
                    sum = sum + this.view[currentCol][currentRow];
                    currentCol--;
                    currentRow++;
                }
                else if(currentRow > endRow){
                    sum = sum + this.view[currentCol][currentRow];
                    currentCol--;
                    currentRow--;
                }
                totalNum = totalNum + 1;
            }
        }
        return sum/totalNum;
    }
}
