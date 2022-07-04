1. 설정은 다음과 같이 한다.

![chap01_start](/Users/isoyeon/Documents/study/android-study/summary/images/part2/chap01_start.png)

2. 레이아웃은 ConstraintLayout이 아닌 LinearLayout을 사용

   - Linear 하게 들어가는 레이아웃...(당연한 얘기)

3. inputType이 number면 정수만, numberSigned은 소수점까지 받을 수 있게 해준다.

4. padding과 margin을 이용하여 각 element의 공간을 추가한다.

   - padding - 어떤 컴포넌트의 **안**에 여백 추가
   - margin - 어떤 컴포넌트의 **밖**에 여백 추가

5. textSize="20sp"를 사용하는 이유 - 각 사람이 본인의 기기에서 설정한 환경설정에 맞게끔 반영하기 위해서

   - dp는 고정이 되며, 안드로이드 스튜디오에서 sp를 사용하는 것을 권장하는 문구가 뜸)

6. 텍스트 색깔처럼 변동될 수 있는 값들은 values/colors.xml 에 추가해주면 된다

   ```xml
   <!-- colors.xml -->
   <color name="custom_black">#222222</color>
   
   <!-- activity_main.xml -->
   android:textColor="@color/custom_black"
   ```

   

7. 6번과 동일하게 변동될 수 있는 값들은 values/strings.xml에 추가해주면 된다

```xml
<!-- strings.xml -->
<string name="height">신장</string>

<!-- activity_main.xml -->
android:text="@string/height"
```



8. 정렬을 위한 Reformat 단축키 - option + comand + L (Ctrl + Alt + L for Win/Linux)
9. findViewByID는 T! 를 반환하는데, !는 절대로 null이 절대로 될 수 없는 타입임을 나타낸다 (?는 null이 될 수도 있음을 나타낸다)
10. 다음의 코드로 text값을 String으로 변경하고, 그 값을 다시 Integer 형태로 변환한다.

```kotlin
val height: Int = heightEditText.text.toString().toInt()
```

11. 현재 나는 MainActivity(this)이고, 다음으로 ResultActivity로 넘어가고 싶어(ResultActivity::class.java)

```kotlin
val intent = Intent(this, ResultActivity::class.java)
startActivity(intent)
```

12. Activity를 추가하게 되면, AndroidManifest.xml에 알려줘야함

```xml
<activity android:name=".ResultActivity" />
```

13. ```xml
    android:layout_gravity="center" <!-- 가운데 정렬 -->
    ```