# JavaFX Курсовая работа на тему "Строительная фирма"
Создать программу реализующую систему “Строительная фирма”.

## Условие задачи
Создать программу реализующую систему “Строительная фирма”.

• Заказчик представляет Техническое Задание (ТЗ) на проектирование дома. 

• Главный конструктор регистрирует ТЗ.

• Главный конструктор определяет стоимость проектирования и строительства, выставляет Заказчику Счет за проектирование и после оплаты создает Бригаду Конструкторов для выполнения Проекта.

## Цель программы
Цель программы – показать алгоритм работы между заказчиком и главным конструктором строительной фирмы. Дополнительными функциями программы являются возможности расформировать бригаду и возможность заказчику просмотреть подробную информацию о бригаде, которая занимается его заказом.

## Элементы интерфейса и порядок работы с ним
Основные функции программы
При загрузке программы появляется стартовое окно (скриншот 1). При нажатии на кнопку «Заказчик» открывается меню заказчика (скриншот 2). При нажатии на кнопку «Главный конструктор» открывается меню главного конструктора (скриншот 3). При нажатии на кнопку «Очистить данные» перезаписываются файлы с заказами и членами бригад.


![Скриншот 1](https://i.imgur.com/84TxsfT.png)

_Скриншот 1 - Стартовое окно_

![Скриншот 2](https://i.imgur.com/l1AqFVO.png)

_Скриншот 2 - Меню заказчика_

![Скриншот 3](https://i.imgur.com/Djxw7sw.png)

_Скриншот 3 - Меню главного конструктора_


Меню заказчика и конструктора содержат таблицы, которые заполняются из файла, содержащего информацию о заказах.
Если таблицу не удаётся заполнить из файла, то файлы перезаписываются до «чистого» состояния. В меню заказчика можно выбрать нужный заказ и узнать о нём больше, нажав на кнопку «Подробнее», открыв окно «Просмотр заказа» (скриншот 4), либо добавить новый заказ, нажав на кнопку «Добавить заказ», открыв окно добавления заказа (скриншот 5).

В меню главного конструктора можно выбрать заказ из таблицы и изменить его, а именно зарегистрировать, указать цену и сформировать бригаду.

![Скриншот 4](https://i.imgur.com/uhRgGZJ.png)

_Скриншот 4 - Окно просмотра заказа_

![Скриншот 5](https://i.imgur.com/RXRoKwF.png)

_Скриншот 5 - Окно добавления заказа_


При создании заказа вам необходимо заполнить поле с техническим заданием. При нажатии кнопки «Отмена» - вас вернёт в меню заказчика. При нажати кнопки «Отправить» ваш заказ записывается в файл и после из него выводится в таблицу.

![Скриншот 6](https://i.imgur.com/V3zrJIC.png)

_Скриншот 6 - Состав бригады, работающей над заказом_

![Скриншот 7](https://i.imgur.com/Zq2eKBN.png)

_Скриншот 7 - Окно редактирования заказа со стороны конструктора_


Кнопка «Сформировать бригаду» становится доступна только после оплаты заказа со стороны заказчика. Кнопка «Зарегистрировать заказ» становится доступна только для незарегистрированных заказов, без указанной цены. Поле с ценой не может содержать любое значение, отличное от натурального числа. При нажатии на кнопку «Сформировать бригаду» открывается окно формирования бригады (скриншот 8).

![Скриншот 8](https://i.imgur.com/8FFcJEd.png)

_Скриншот 8 - Окно формирования бригады_


Данное окно содержит таблицу со всеми рабочими строительной фирмы. Рабочего можно нанять на выбранный заказ только при условии, что он свободен, нажав на кнопку «Нанять». Чтобы освободить рабочего нужно нажать на кнопку «Снять», тогда рабочий меняет статус на свободен и снимается с заказа, на котором был закреплен.
Нажав на кнопку «Добавить» открывается меню добавления нового рабочего (скриншот 9).

![Скриншот 9](https://i.imgur.com/8RuCfJZ.png)

_Скриншот 9 - Окно добавления рабочего_


В этом окне вы можете задать имя и стаж работы рабочему и при нажатии на кнопку «Добавить», рабочий вносится в список всех рабочих строительной фирмы и может быть нанят на заказы. Поля с именем и стажем не могут быть пустыми, а также поле со стажем не может содержать значения, отличные от натуральных чисел в диапазоне от 0 до 100.

## Диаграмма классов
![](https://sun9-68.userapi.com/impg/mCoEuLedQH9LlquJvBe5l7kD59SgXRfO-ai1yA/zXNUKVFeJLM.jpg?size=1763x1673&quality=96&sign=8ee8075d332752734f0f20f817b30b76&type=album)
