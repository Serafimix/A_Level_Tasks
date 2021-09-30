package ua.rakhmail.hw18;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Box {
    private String from;
    private String material;
    private String color;
    private MaxLiftingCapacity maxLiftingCapacity;
    private Cargo cargo;
    private Date deliveryDate;

    public Box(String file) {
        Cargo cargo = new Cargo();
        MaxLiftingCapacity maxLiftingCapacity = new MaxLiftingCapacity();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            if (file.endsWith(".json")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String text;
                    while ((text = reader.readLine()) != null) {
                        Matcher mFrom = Pattern.compile("from\": \"(.+?)\"").matcher(text);
                        Matcher mMaterial = Pattern.compile("material\": \"(.+?)\"").matcher(text);
                        Matcher mColor = Pattern.compile("color\": \"(.+?)\"").matcher(text);
                        Matcher mUnit = Pattern.compile("unit\": \"(.+?)\"").matcher(text);
                        Matcher mValue = Pattern.compile("value\": (\\d+)").matcher(text);
                        Matcher mName = Pattern.compile("name\": \"(.+?)\"").matcher(text);
                        Matcher mCargoClass = Pattern.compile("class\": \"(.+?)\"").matcher(text);
                        Matcher mDate = Pattern.compile("date\": \"(.+?)\"").matcher(text);
                        if (mFrom.find()) {
                            from = mFrom.group(1);
                        }
                        if (mMaterial.find()) {
                            material = mMaterial.group(1);
                        }
                        if (mColor.find()) {
                            color = mColor.group(1);
                        }
                        if (mUnit.find()) {
                            maxLiftingCapacity.setUnit(mUnit.group(1));
                        }
                        if (mValue.find()) {
                            maxLiftingCapacity.setValue(Integer.parseInt(mValue.group(1)));
                        }
                        if (mName.find()) {
                            cargo.setName(mName.group(1));
                        }
                        if (mCargoClass.find()) {
                            cargo.setCargoClass(mCargoClass.group(1));
                        }
                        if (mDate.find()) {
                            deliveryDate = simpleDateFormat.parse(mDate.group(1));
                        }
                    }
                    this.cargo = cargo;
                    this.maxLiftingCapacity = maxLiftingCapacity;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (file.endsWith(".xml")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String text;
                    while ((text = reader.readLine()) != null) {
                        Matcher mFrom = Pattern.compile("from=\"(.+?)\"").matcher(text);
                        Matcher mMaterial = Pattern.compile("material=\"(.+?)\"").matcher(text);
                        Matcher mColor = Pattern.compile("<color>(.+?)<").matcher(text);
                        Matcher mUnit = Pattern.compile("unit=\"(.+?)\"").matcher(text);
                        Matcher mValue = Pattern.compile(">(\\d+)<").matcher(text);
                        Matcher mName = Pattern.compile("<name>(.+?)<").matcher(text);
                        Matcher mCargoClass = Pattern.compile("<class>(.+?)<").matcher(text);
                        Matcher mDate = Pattern.compile("<delivery-date>(.+?)<").matcher(text);
                        if (mFrom.find()) {
                            from = mFrom.group(1);
                        }
                        if (mMaterial.find()) {
                            material = mMaterial.group(1);
                        }
                        if (mColor.find()) {
                            color = mColor.group(1);
                        }
                        if (mUnit.find()) {
                            maxLiftingCapacity.setUnit(mUnit.group(1));
                        }
                        if (mValue.find()) {
                            maxLiftingCapacity.setValue(Integer.parseInt(mValue.group(1)));
                        }
                        if (mName.find()) {
                            cargo.setName(mName.group(1));
                        }
                        if (mCargoClass.find()) {
                            cargo.setCargoClass(mCargoClass.group(1));
                        }
                        if (mDate.find()) {
                            deliveryDate = simpleDateFormat.parse(mDate.group(1));
                        }
                    }
                    this.cargo = cargo;
                    this.maxLiftingCapacity = maxLiftingCapacity;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}