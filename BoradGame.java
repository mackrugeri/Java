interface Borad{
    public String toString(int min, int max, String game_name, int size);
}
class BoardGame extends Game implements Borad
{
    private
    int min_value;
    int max_value;
    String player;
    String[] space = new String[40];

    BoardGame(int min,int max,String number_player,String[]spaces)
    {
        min_value = min;
        max_value = max;
        number_player = player;
        for(int i =0; i<40;i++)
        {
            space[i] = spaces[i];
        }
    }

    BoardGame(int min_value, int max_value, String player, String s) {
    }

    public BoardGame() {

    }

    public String toString(int min, int max, String game_name, int size) {

        String var = game_name + String.valueOf(min) + "-" + String.valueOf(max) + "player" +  String.valueOf(size);
        return var;
    }
}