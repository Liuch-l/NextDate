import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.*;

public class Main extends Application {

    //文本框
    TextField textField = new TextField();
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();

    //标签
    Label label = new Label("计算下一天：");
    Label label1 = new Label("年");
    Label label2 = new Label("月");
    Label label3 = new Label("日");
    Label label4 = new Label("下一天");

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("请分别输入年、月、日");
        //判断形状按钮
        Button Judge_bt = new Button("计算下一天");
        //重新输入按钮
        Button Anew_bt = new Button("重新输入");


        //绑定按钮事件
        Anew_bt.setOnAction(e -> DeleteAnew());
        Judge_bt.setOnAction(e -> Judge());




        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        pane.add(label,0,0);
        pane.add(label1,0,1);
        pane.add(textField,1,1);
        pane.add(label2,0,2);
        pane.add(textField1,1,2);
        pane.add(label3,0,3);
        pane.add(textField2,1,3);
        pane.add(label4,0,4);
        pane.add(textField3,1,4);
        pane.add(Judge_bt,0,5);
        pane.add(Anew_bt,1,5);


        primaryStage.setScene(new Scene(pane, 400, 275));
        //禁止改变舞台大小
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void Judge() {
        try {
            int year = Integer.valueOf(textField.getText());
            int month = Integer.valueOf(textField1.getText());
            int date = Integer.valueOf(textField2.getText());
            switch (month)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(date > 31)
                        textField3.setText("不可能");
                    else
                    {
                        if(month == 12 && date == 31)
                            textField3.setText((year+1)+"年1月1日");
                        else if(date == 31)
                        {
                            textField3.setText(year+"年"+(month+1)+"月1日");
                        }
                        else
                        {
                            textField3.setText(year+"年"+month+"月"+(date+1)+"日");
                        }
                    }
                    break;


                case 2:


                        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                            if (date == 29)
                                textField3.setText(year+"年"+(month+1)+"月1日");
                            else textField3.setText(year+"年"+month+"月"+(date+1)+"日");

                        }
                        else if(date<29)
                        {
                            if (date == 28)
                                textField3.setText(year+"年"+(month+1)+"月1日");
                            else textField3.setText(year+"年"+month+"月"+(date+1)+"日");
                        }

                    else
                    textField3.setText("不可能");
                    break;

                case 4:
                case 6:
                case 9:
                case 11:
                    if(date > 30)
                        textField3.setText("不可能");
                    else
                    {
                        if(month == 11 && date == 30)
                            textField3.setText(year+"年12月1日");
                        else if(date == 30)
                        {
                            textField3.setText(year+"年"+(month+1)+"月1日");
                        }
                        else
                        {
                            textField3.setText(year+"年"+month+"月"+(date+1)+"日");
                        }
                    }
                    break;
            }



        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"参数输入非法！");
        }

    }



    private void DeleteAnew() {
        textField.setText("");
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");

    }


    public static void main(String[] args) {
        launch(args);
    }



}