package bsu.rfe.java.group9.lab2.Kutsis.var13;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.*;

import static java.lang.Math.*;
import static java.lang.StrictMath.log;

    @SuppressWarnings("serial")

    public class Main extends JFrame {
        // Размеры окна приложения в виде констант
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;
        private JPanel formulaPicturePanel;
        private ImageIcon image;
        // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
        private JTextField textFieldX;
        private JTextField textFieldY;
        private JTextField textFieldZ;
        // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
        private JTextField textFieldResult;
        private JTextField textFieldMemory;
        // Группа радио-кнопок для обеспечения уникальности выделения в группе
        private ButtonGroup radioButtons = new ButtonGroup();
        private ButtonGroup radioMemButtons = new ButtonGroup();

        // Контейнер для отображения радио-кнопок
        private Box hboxMemoryField = Box.createHorizontalBox();
        private Box hboxFormulaType = Box.createHorizontalBox();
        private Box hboxMemoryidType=Box.createHorizontalBox();
        private Box hboxMemoryButtons=Box.createHorizontalBox();
        private Box hboxFormulaPic = Box.createHorizontalBox();
        private int formulaId = 1;
        private int Memoryid=1;
        private JButton imagePane;
        private JLabel formulaPicture;


        private Double mem1=0.0;
        private Double mem2=0.0;
        private Double mem3=0.0;



        // Формула №1 для рассчѐта
        public Double calculate1(Double x, Double y,Double z) {
            return (pow(log(pow((1+x), 2) + cos(PI+pow(z, 3))), (sin(y)))+pow((exp(pow(x, 2))+cos(exp(z)) + sqrt(1/y)), 1/x));

        }

        // Формула №2 для рассчѐта
        public Double calculate2(Double x, Double y,Double z) {
            return pow(cos(PI+pow(x, 3))+log(pow((1+y), 2)), 1/4)*(exp(pow(z, 2)) + sqrt(1/x)+cos(exp(y)));
        }

        // Вспомогательный метод для добавления кнопок на панель
        private void addRadioButton(String buttonName, final int formulaId) {
            JRadioButton button = new JRadioButton(buttonName);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    Main.this.formulaId = formulaId;
                    if(formulaId == 1)
                    {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read (getClass().getResource("FormulaOne.bmp"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ImageIcon image1 = new ImageIcon(img);
                        formulaPicture.setIcon(image1);
                    }
                    if(formulaId == 2)
                    {
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read (getClass().getResource("FormulaTwo.bmp"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ImageIcon image1 = new ImageIcon(img);
                        formulaPicture.setIcon(image1);
                    }

                }
            });
            radioButtons.add(button);
            hboxFormulaType.add(button);
        }

         private void addMemoryRadioButton(String buttonName, final int Memoryid) {
            JRadioButton button = new JRadioButton(buttonName);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    Main.this.Memoryid = Memoryid;
                    if(Memoryid == 1) {
                        textFieldMemory.setText(Double.toString(mem1));
                    }
                    if(Memoryid == 2)
                    {
                        textFieldMemory.setText(Double.toString(mem2));
                    }
                    if(Memoryid == 3)
                    {
                        textFieldMemory.setText(Double.toString(mem3));
                    }


                }
            });
            radioMemButtons.add(button);
            hboxMemoryidType.add(button);
        }

        // Конструктор класса
        public Main() {
            super("Вычисление формулы");
            setSize(WIDTH, HEIGHT);
            Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
            setLocation((kit.getScreenSize().width - WIDTH) / 2,
                    (kit.getScreenSize().height - HEIGHT) / 2);
            hboxFormulaType.add(Box.createHorizontalGlue());
            addRadioButton("Формула 1", 1);
            addRadioButton("Формула 2", 2);
            addMemoryRadioButton("Переменная 1",1);
            addMemoryRadioButton("Переменная 2",2);
            addMemoryRadioButton("Переменная 3",3);
            BufferedImage img = null;
            try {
                img = ImageIO.read (getClass().getResource("FormulaOne.bmp"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ImageIcon image1 = new ImageIcon(img);
            formulaPicture = new JLabel();
            formulaPicture.setIcon(image1);
            formulaPicturePanel = new JPanel();
            formulaPicturePanel.add(formulaPicture);
            formulaPicturePanel.setMaximumSize(new Dimension(700, 100));
            hboxFormulaPic.add(formulaPicturePanel); // adding element with picture
            radioButtons.setSelected(
                    radioButtons.getElements().nextElement().getModel(), true);
            radioMemButtons.setSelected(
                    radioMemButtons.getElements().nextElement().getModel(), true);
            hboxFormulaType.add(Box.createHorizontalGlue());
            hboxFormulaType.setBorder(
                    BorderFactory.createLineBorder(Color.RED));
// Создать область с полями ввода для X и Y и Z
            JLabel labelForX = new JLabel("X:");
            textFieldX = new JTextField("0", 5);
            textFieldX.setMaximumSize(textFieldX.getPreferredSize());
            JLabel labelForY = new JLabel("Y:");
            textFieldY = new JTextField("0", 5);
            textFieldY.setMaximumSize(textFieldY.getPreferredSize());
            JLabel labelForZ = new JLabel("Z:");
            textFieldZ = new JTextField("0", 5);
            textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
            Box hboxVariables = Box.createHorizontalBox();
            hboxVariables.setBorder(
                    BorderFactory.createLineBorder(Color.RED));
            hboxVariables.add(Box.createHorizontalGlue());
            hboxVariables.add(labelForX);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldX);
            hboxVariables.add(Box.createHorizontalStrut(50));
            hboxVariables.add(labelForY);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldY);
            hboxVariables.add(Box.createHorizontalStrut(50));
            hboxVariables.add(labelForZ);
            hboxVariables.add(Box.createHorizontalStrut(10));
            hboxVariables.add(textFieldZ);
            hboxVariables.add(Box.createHorizontalGlue());
// Создать область для вывода результат
            JLabel labelForResult = new JLabel("Результат:");
//labelResult = new JLabel("0");
            textFieldMemory =new JTextField("0",10);
            textFieldMemory.setMaximumSize(
                    textFieldMemory.getPreferredSize());
            textFieldResult = new JTextField("0", 10);
            textFieldResult.setMaximumSize(
                    textFieldResult.getPreferredSize());
            Box hboxResult = Box.createHorizontalBox();
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.add(labelForResult);
            hboxResult.add(Box.createHorizontalStrut(10));
            hboxResult.add(textFieldResult);
            hboxResult.add(Box.createHorizontalGlue());
            hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
// Создать область для кнопок
            JButton buttonCalc = new JButton("Вычислить");
            buttonCalc.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    try
                    {
                        Double x = Double.parseDouble(textFieldX.getText());
                        Double y = Double.parseDouble(textFieldY.getText());
                        Double z = Double.parseDouble(textFieldZ.getText());

                        Double result;
                        if (formulaId == 1)
                            result = calculate1(x, y ,z);
                        else
                            result = calculate2(x, y ,z);
                        textFieldResult.setText(result.toString());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Main.this,
                                "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            });
            JButton Memoryplus = new JButton("M+");
            Memoryplus.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev)
                {
                    if(Memoryid==1)
                    {
                        mem1+=Double.parseDouble(textFieldResult.getText());
                        textFieldMemory.setText(String.valueOf(mem1));
                    }
                    if(Memoryid==2)
                    {
                        mem2+=Double.parseDouble(textFieldResult.getText());
                        textFieldMemory.setText(String.valueOf(mem2));
                    }
                    if(Memoryid==3)
                    {
                        mem3+=Double.parseDouble(textFieldResult.getText());
                        textFieldMemory.setText(String.valueOf(mem3));
                    }
                }
            });
            JButton Memoryclear = new JButton("MC");
            Memoryclear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev)
                {
                    if(Memoryid==1)
                    {
                        mem1=0.0;
                        textFieldMemory.setText(String.valueOf(mem1));
                    }
                    if(Memoryid==2)
                    {
                        mem2=0.0;
                        textFieldMemory.setText(String.valueOf(mem2));
                    }
                    if(Memoryid==3)
                    {
                        mem3=0.0;
                        textFieldMemory.setText(String.valueOf(mem3));
                    }
                }
            });

            JButton buttonReset = new JButton("Очистить поля");
            buttonReset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ev) {
                    textFieldX.setText("0");
                    textFieldY.setText("0");
                    textFieldResult.setText("0");
                    textFieldMemory.setText("0");
                }
            });
            Box hboxButtons = Box.createHorizontalBox();
            hboxButtons.add(Box.createHorizontalGlue());
            hboxButtons.add(buttonCalc);
            hboxButtons.add(Box.createHorizontalStrut(30));
            hboxButtons.add(buttonReset);
            hboxButtons.add(Box.createHorizontalGlue());
            hboxButtons.setBorder(
                    BorderFactory.createLineBorder(Color.RED));
// Связать области воедино в компоновке BoxLayout
            hboxMemoryButtons.add(Memoryplus);
            hboxButtons.add(Box.createHorizontalStrut(10));
            hboxMemoryButtons.add(Memoryclear);
            hboxMemoryField.add(Box.createVerticalGlue());
            hboxMemoryField.add(textFieldMemory);
            Box contentBox = Box.createVerticalBox();
            contentBox.add(Box.createVerticalGlue());
            contentBox.add(hboxFormulaPic);
            contentBox.add(hboxFormulaType);
            contentBox.add(hboxMemoryidType);
            contentBox.add(hboxVariables);
            contentBox.add(hboxResult);
            contentBox.add(hboxButtons);
            contentBox.add(hboxMemoryButtons);
            contentBox.add(hboxMemoryField);
            contentBox.add(Box.createVerticalGlue());
            getContentPane().add(contentBox, BorderLayout.CENTER);
        }

        // Главный метод класса
        public static void main(String[] args) {
            Main frame = new Main();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

    }

