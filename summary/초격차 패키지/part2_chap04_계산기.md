1. ```xml
   android:shrinkColumns="*"
   ```

​		위 같은 속성을 넣으면, 속성들이 균일하게 배치됨

2. Android material 중 ripple 기능을 사용하면 버튼을 눌렀을 때 쏵-하고 퍼져나가는 느낌의 버튼 생성 가능
3. 안드로이드에는 기본적으로 버튼을 눌렀을 때 실행되는 애니메이션이 있는데, 이를 없애주는 것이 다음의 코드다

​		`android:stateListAnimator="@null"`

