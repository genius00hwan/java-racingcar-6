## model
- Car
  - field : name, locationHistory, isWinner
  - method
    - 생성자 : string -> Car
    - validateName : 이름 길이
    - validateLocation : 음수인지 아닌지
    - move(int)
    - getCurrentLocation
    - getLocation(i)
- Round
  - field : (final) numberOfRound, currentRound
  - 생성자 : string -> integer
  - hasMoreRound : currentRound <= numberOfRound
  - validateRound : 정수인지 아닌지, 음수인지 아닌지,  

## view
- InputView
  - inputCarNames()
  - inputNumberOfRounds()
  - parseCarNames()
  - inputUserString()
  - parseInteger()
- OutputView
  - printResult
  - printRoundStatus
  - printWinner

## service
- GenerateService
  - generateCars(List<String>)
    - return List<Cars>
  - generateACar(String)
    - return Car
- AdvanceService
  - advanceCars(List<Cars>)
  - advanceACar()
- JudgeService
  - List<Cars> judgeWinner(List<Cars>)
  - calculateWinningScore

## exception
- IllegalCarNameException
- IllegalNumberOfRoundsException
