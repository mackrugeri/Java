interface  IDiceGame{
    public void set_dice_value(int value);
    public int _get_dice_value();
    public int getNumDice();
}

class parcheesi extends BoardGame implements IDiceGame{

    private
    int min_value;
    int max_value;
    String player;
    String[] space = new String[40];
    int dice_value =0;

    parcheesi() {
        super();
        for (int i =0;i<40;i++)
        {
            space[i] = "a";
        }
        min_value = 2;
        max_value = 4;
        player = "Parcheesi";
        new BoardGame(min_value,max_value, player,space);
    }
    public void set_dice_value(int value)
    {
        dice_value = value;
    }
    public int _get_dice_value()
    {
        return dice_value;
    }
    public int getNumDice()
    {
        return (int)(Math.random() * 6) + 1;
    }



}
