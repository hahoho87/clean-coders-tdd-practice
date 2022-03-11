## 볼링게임

- 볼링 게임은 10개의 프레임으로 구성
- 각 프레임은 대게 2 롤을 갖음
    - 10개의 핀을 쓰러뜨리기 위해 2번의 기회를 갖음
- Spare : 10 + next first roll 에서 쓰러뜨린 핀수
- Strike : 10 + text two rolls 에서 쓰러 뜨린 핀 수
- 10th 프레임은 특별. spare 처리하면 3번 던질 수 있음
- Game class
    - roll(pins: int)
        - ball 을 roll 할 때마다 호출
        - 쓰러뜨린 핀 수 - 인자
    - score() : int
        - 게임이 끝난 후에만 호출
        - 게임의 점수 반환
