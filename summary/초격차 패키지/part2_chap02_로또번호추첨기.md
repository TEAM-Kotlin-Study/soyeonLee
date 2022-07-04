1. Constraint layout - 강제, 제약 이란 의미로, 강제적으로 배치할 수 있게 도와주는 레이아웃이라고 생각
   - constraint_layout에서는 match_parent를 권장하지 않음 
   - LinearLayout이 ConstraintLayout에 밀리게 된 것은 스마트폰의 다양한 화면에 비율에 따라 매치하기 힘들기 때문
   - layout_width과 layout_height 값은 0dp로 설정해야 constraint에 매치되어 구조가 잡힘
2. constraint(A)_to(B)Of - 상/하/좌/우를 다른 뷰의 어느 곳에 연결할 것인지 정해주는 옵션으로, constraint를 정해주지 않으면 경고 표시가 발생하며, View를 다른 곳으로 연결하지 않은 채 앱을 실행하면 View가 좌측 상단으로 이동해버림. 때문에 반드시 다른 View 혹은 Parent에 연결
   - App:layout_constraintLeft_toRightOf="@+id/buttonA" - 해당 레이아웃의 왼쪽을 buttonA의 오른쪽에 붙어라.
   - ~ 물결 표시 - 이 영역을 나눠 가지고 있음