1级实践_赵君毅_ZY1221227_王淇_ZY1221211

停车场经理任务分解:
1、让停车仔停车成功
2、让停车仔取车成功
3、让停车仔停车失败（没有找到指定的停车仔）
打印报表任务分解:
1、打印停车场的消息成功
2、打印停车仔的消息成功
3、打印停车经理的消息成功

运行说明:
1.本程序运行需要jdk1.7或者以上版本；
2.运行前需要正确设置jdk的运行环境；

类说明:
1、Car:用于存放到停车场的汽车类。
2、Ticket:停车后生成的取车凭证，具有停车场编号等属性。
3、Parking:停车场类，具有停车场编号、最多停车数等属性。可以停车，取车，返回空余车位以及返回空置率。
4、ParkingAssistan:停车仔类，具有编号，所管理的停车场等属性。可以存车，取车，返回停车场空余数以及停车场停车数。
5、ParkingManager:停车经理类，继承于ParkingAssistant。额外具有所管理的停车仔等属性。能够通过停车仔取车或停车。能够打印停车仔，停车场等消息。
6、ParkingDirector:停车主管类，继承于ParkingAssistant。额外具有所停车经理等属性。能够打印停车经理的信息。
7、Parkinglotchooser:实现不同停车策略的接口类。
8、FirstAvailableParkingLotChooser:实现默认的停车策略，即从第一个停车场停车，直到最后一个停车场停满。
9、MaxAvailableParkingLotChooser:实现往停车数较少的停车场停车的策略。
10、LeastUsedAvailableParkingLotChooser:实现往空置率最高的停车场停车的策略。
11、NoCarException:当没有找到相应汽车时报出的异常类。
12、NoPositionException:当停车场没有停车位时报出的异常类。
13、NoParkingAssistantException:当没有找到相应停车仔时报出的异常类。

测试说明:
1、ParkingTest:包括对停车场成功停车、成功取车、停车失败、取车失败以及对往停车数最少的停车场停车的停车策略（包括当两种停车场车位相同与不同两种情况）进行了测试。
2、SuperParkingBoyTest:对往空置率最高的停车场停车的停车策略进行了测试。
3、ParkingManagerTest:包括通过停车仔停车、取车以及通过停车仔停车失败的测试。
4、PrintInfoTest:包括打印停车场信息、停车仔信息以及停车经理的信息。