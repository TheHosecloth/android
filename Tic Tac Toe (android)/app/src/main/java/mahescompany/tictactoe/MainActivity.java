package mahescompany.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     int player = 1; //cross
    int  [] status = {20, 20,20, 20, 20, 20, 20, 20, 20};
    LinearLayout layout;
    GridLayout grid;
    Button button;
    int count = 0;
    boolean game_end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        layout = (LinearLayout) findViewById(R.id.layout);
        grid = (GridLayout) findViewById(R.id.grid);
    }

    public void playagain(View v) {
        count = 0;
        for (int i = 0; i < 9; i++)
            status[i] = 20;

        layout.setVisibility(View.INVISIBLE);
        game_end = false;
        for (int i = 0; i < grid.getChildCount(); i++) {
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
    }//end play again

     public int check() {
         int n;
         for (int  i = 0; i < 9; i += 3) {
             n = status[i] + status[i + 1] + status[i + 2];
             if ( (n == 0) || (n == 3) )
                 return n;
         }//end for

         for (int  i = 0; i < 3; i ++) {
             n = status[i] + status[i + 3] + status[i + 6];
             if ( (n == 0) || (n == 3) )
                 return n;
         }//end for
         n = status[0] + status[ 4 ] + status[ 8 ];
         if ( (n == 0) || (n == 3) )
             return n;

         n = status[2] + status[ 4 ] + status[ 6 ];
         if ( (n == 0) || (n == 3) )
             return n;

         return 20;

     }//end check

    public void dropin (View v) {
       if ( !game_end ) {
           ImageView counter = (ImageView) v;
           int loc = Integer.parseInt(counter.getTag().toString());
           if (status[loc] == 20) {
               count++;
               counter.setTranslationY(-1000f);
               status[loc] = player;
               if (player == 0)
                   counter.setImageResource(R.drawable.zero);
               else
                   counter.setImageResource(R.drawable.cross);
               player = 1 - player;
               counter.animate().translationYBy(1000f).rotation(3600).setDuration(600);
               int outcome = check();
               if (outcome == 0)
                   Toast.makeText(getApplicationContext(), "O won ", Toast.LENGTH_LONG).show();
               else if (outcome == 3)
                   Toast.makeText(getApplicationContext(), "X won ", Toast.LENGTH_LONG).show();
               else if (count == 9)
                   Toast.makeText(getApplicationContext(), "Tie Game", Toast.LENGTH_LONG).show();

               if ((outcome == 0) || (outcome == 3) || (count == 9)) {
                   layout.setVisibility(1);
                   game_end = true;
               }//if
           }//endif

           computerMove();
       }//if game_end
    }//

    public void computerMove() {
        ImageView bestCell = (ImageView) findViewById(R.id.imageView);

        if ( ((status[1] == 0 && status[2] == 0) ||
                (status[3] == 0 && status[6] == 0) ||
                (status[4] == 0 && status[8] == 0)) && status[0] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView);
            Toast.makeText(getApplicationContext(), "Cell 1 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if ( ((status[0] == 0 && status[2] == 0) ||
                (status[4] == 0 && status[7] == 0)) && status[1] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView2);
            Toast.makeText(getApplicationContext(), "Cell 2 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 0 && status[1] == 0) ||
                (status[5] == 0 && status[8] == 0) ||
                (status[4] == 0 && status[6] == 0)) && status[2] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView3);
            Toast.makeText(getApplicationContext(), "Cell 3 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 0 && status[6] == 0) ||
                (status[4] == 0 && status[5] == 0))  && status[3] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView4);
            Toast.makeText(getApplicationContext(), "Cell 4 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 0 && status[8] == 0) ||
                (status[2] == 0 && status[6] == 0) ||
                (status[1] == 0 && status[7] == 0) ||
                (status[3] == 0 && status[5] == 0)) && status[4] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView5);
            Toast.makeText(getApplicationContext(), "Cell 5 chosen as winning play!", Toast.LENGTH_SHORT).show();

        }

        else if (((status[2] == 0 && status[8] == 0) ||
                (status[3] == 0 && status[4] == 0))  && status[5] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView6);
            Toast.makeText(getApplicationContext(), "Cell 6 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 0 && status[3] == 0) ||
                (status[7] == 0 && status[8] == 0) ||
                (status[2] == 0 && status[4] == 0))   && status[6] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView7);
            Toast.makeText(getApplicationContext(), "Cell 7 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[1] == 0 && status[4] == 0) ||
                (status[6] == 0 && status[8] == 0))   && status[7] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView8);
            Toast.makeText(getApplicationContext(), "Cell 8 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 0 && status[4] == 0) ||
                (status[6] == 0 && status[7] == 0) ||
                (status[2] == 0 && status[5] == 0))   && status[8] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView9);
            Toast.makeText(getApplicationContext(), "Cell 9 chosen as winning play!", Toast.LENGTH_SHORT).show();
        }

        else if ( ((status[1] == 1 && status[2] == 1) ||
                (status[3] == 1 && status[6] == 1) ||
                (status[4] == 1 && status[8] == 1)) && status[0] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView);
            Toast.makeText(getApplicationContext(), "Cell 1 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if ( ((status[0] == 1 && status[2] == 1) ||
                (status[4] == 1 && status[7] == 1)) && status[1] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView2);
            Toast.makeText(getApplicationContext(), "Cell 2 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 1 && status[1] == 1) ||
                (status[5] == 1 && status[8] == 1) ||
                (status[4] == 1 && status[6] == 1)) && status[2] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView3);
            Toast.makeText(getApplicationContext(), "Cell 3 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 1 && status[6] == 1) ||
                (status[4] == 1 && status[5] == 1))  && status[3] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView4);
            Toast.makeText(getApplicationContext(), "Cell 4 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 1 && status[8] == 1) ||
                (status[2] == 1 && status[6] == 1) ||
                (status[1] == 1 && status[7] == 1) ||
                (status[3] == 1 && status[5] == 1)) && status[4] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView5);
            Toast.makeText(getApplicationContext(), "Cell 5 chosen as blocking play!", Toast.LENGTH_SHORT).show();

        }

        else if (((status[2] == 1 && status[8] == 1) ||
                (status[3] == 1 && status[4] == 1))  && status[5] == 20) {
            bestCell = (ImageView) findViewById(R.id.imageView6);
            Toast.makeText(getApplicationContext(), "Cell 6 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 1 && status[3] == 1) ||
                (status[7] == 1 && status[8] == 1) ||
                (status[2] == 1 && status[4] == 1))   && status[6] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView7);
            Toast.makeText(getApplicationContext(), "Cell 7 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[1] == 1 && status[4] == 1) ||
                (status[6] == 1 && status[8] == 1))   && status[7] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView8);
            Toast.makeText(getApplicationContext(), "Cell 8 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else if (((status[0] == 1 && status[4] == 1) ||
                (status[6] == 1 && status[7] == 1) ||
                (status[2] == 1 && status[5] == 1))   && status[8] == 20){
            bestCell = (ImageView) findViewById(R.id.imageView9);
            Toast.makeText(getApplicationContext(), "Cell 9 chosen as blocking play!", Toast.LENGTH_SHORT).show();
        }

        else {
            bestCell = bestNonWinningCell();
//            Toast.makeText(getApplicationContext(), "NO BEST CELL SELECTED :(", Toast.LENGTH_SHORT).show();
        }

        int loc = Integer.parseInt(bestCell.getTag().toString());
        if (status[loc] == 20) {
            count++;
            bestCell.setTranslationY(-1000f);
            status[loc] = player;
            if (player == 0)
                bestCell.setImageResource(R.drawable.zero);
            else
                bestCell.setImageResource(R.drawable.cross);
            player = 1 - player;
            bestCell.animate().translationYBy(1000f).rotation(3600).setDuration(600);
            int outcome = check();
            if (outcome == 0)
                Toast.makeText(getApplicationContext(), "O won ", Toast.LENGTH_LONG).show();
            else if (outcome == 3)
                Toast.makeText(getApplicationContext(), "X won ", Toast.LENGTH_LONG).show();
            else if (count == 9)
                Toast.makeText(getApplicationContext(), "Tie Game", Toast.LENGTH_LONG).show();

            if ((outcome == 0) || (outcome == 3) || (count == 9)) {
                layout.setVisibility(1);
                game_end = true;
            }//if
        }//endif

    }   // END computer move

    public ImageView bestNonWinningCell() {
        if (status[0] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 1 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView);
        }
        if (status[2] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 3 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView3);
        }
        if (status[6] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 7 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView7);
        }
        if (status[8] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 9 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView9);
        }

        if (status[4] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 5 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView5);
        }

        if (status[1] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 2 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView2);
        }
        if (status[3] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 4 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView4);
        }
        if (status[5] == 20) {
            Toast.makeText(getApplicationContext(), "Cell 6 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
            return (ImageView) findViewById(R.id.imageView6);
        }

        Toast.makeText(getApplicationContext(), "Cell 8 chosen as best non-winning move", Toast.LENGTH_SHORT).show();
        return (ImageView) findViewById(R.id.imageView8);
    }
}//endclass
