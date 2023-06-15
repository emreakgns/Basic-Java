import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyClock extends JFrame {
    private Calendar calendar;
    private SimpleDateFormat time , date , day;
    private JLabel timeLabel , dateLabel , dayLabel;

    private String myday , mydate , mytime;
    public MyClock(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Digital Clock");
        setSize(300, 200);
        setResizable(false);

        time = new SimpleDateFormat("hh:mm:ss a");
        day = new SimpleDateFormat("EEEE");
        date =new SimpleDateFormat("dd MMMMM, yyyy");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);
        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Arial",Font.BOLD,34));
        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Arial",Font.BOLD,30));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dayLabel, BorderLayout.NORTH);
        panel.add(dateLabel, BorderLayout.SOUTH);

        this.add(panel);
        setVisible(true);

        setTimer();

    }

    public void setTimer() {
        while (true) {
            mytime = time.format(Calendar.getInstance().getTime());
            timeLabel.setText(mytime);

            myday = day.format(Calendar.getInstance().getTime());
            dayLabel.setText(myday);

            mydate = date.format(Calendar.getInstance().getTime());
            dateLabel.setText(mydate);

            try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
            e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyClock();
    }
    
}
