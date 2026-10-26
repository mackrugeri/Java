interface Card{
    public String toString(int min, int max, String game_name, int size);
}

class CardGame extends Game implements Card{


    private
    int min_value;
    int max_value;
    String player;
    int cards;

    public
    CardGame(int min,int max,String number_of_players,int number_of_cards)
    {
        min_value =min;
        max_value = max;
        player = number_of_players;
        cards = number_of_cards;
    }

    public String toString(int min, int max, String game_name, int size) {

        String var = game_name + String.valueOf(min) + "-" + String.valueOf(max) + "player" +  String.valueOf(size);
        return var;
    }

}

