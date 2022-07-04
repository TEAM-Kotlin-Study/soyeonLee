1. font는 res폴더에 font라는 폴더를 만들어 접근
   - font resource는 대문자를 지원하지 않음

2. 안드로이드의 themes.xml 때문에 button이나 layout 색이 바뀌지 않는 이슈가 있음
   - 단순하게 Button 태그로 작성 시,  themes.xml의 영향을 많이 받게 됨
   - 이런 이슈를 피하려면, `android.appcompat.widget.AppCompatButton`으로 바꾸어 적용

3. ActionBar 지우기

   1. themes 밑에 다음과 같은 코드 추가

   ```xml
   <style name="Theme.Aoppart2chapter3.NoActionBar" parent="Theme.MaterialComponents.DayNight.NoActionBar" />
   ```

   2. AndroidManifest.xml에 추가한 테마를 등록

   ```xml
   <activity
               android:name=".MainActivity"
               android:theme="@style/Theme.Aoppart2chapter3.NoActionBar" <!-- 테마 등록 -->
               android:exported="true">
               <intent-filter>
                   <action android:name="android.intent.action.MAIN" />
   
                   <category android:name="android.intent.category.LAUNCHER" />
               </intent-filter>
           </activity>
   ```

4. view를 lazy하게 초기화하는 이유 - MainActivity가 생성될 시점에는 View가 아직 생성되기 전임. View가 다 그려졌다고 알려주는 함수가 onCreate인데, 이 onCreate가 생성되고 나서 numberPicker가 호출될 것이기 때문

5. AlertDialog 띄우기

   ```kotlin
   AlertDialog.Builder(this)
       .setTitle("실패!!")
       .setMessage("비밀번호가 잘못되었습니다.")
       .setPositiveButton("확인") { _, _ -> }
       .create()
       .show()
   ```

6. Handler - Thread를 관리를 할 때 사용