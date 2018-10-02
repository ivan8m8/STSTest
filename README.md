# Тестовое задание для СТС
## Задача
Необходимо реализовать простейшее приложение, которое будет отображать список случайной длины от 10 до 100 элементов. 
При тапе по элементу открывать новый экран с отображением подробной информации об элементе.
Список формируется случайным способом из объектов трех типов:
````
data class Notice {
  var flightDate: Date? =
  var gate: String? =
}

class Event {
  var startTime: Date? =
  var endTime: Date? =
  var name: String! =
}

class Move {
  var fromPlace: String? =
  var toPlace: String? =
  var estimateTime: TimeInterval? =
}
````
Ячейка списка содержит текстовое описание объекта в виде "название" - "детали". 
На экране деталей - подробная информация в виде полей взависимости от типа элемента.

* Возможно расширение указанных типов как угодно<br>
* Можно запрашивать уточнения<br>
* Желательна реализация на Kotlin (типы описаны именно на нем)типы описаны именно на нем)<br>
* Надо закладывать масштабирование - в будущем возможно появление новых типов, соответствующих условиям задачи.<br>

## Решение
1. Каждый из исходных классов реализует интерфейс ``Inlinable``, 
единственный метод которого ``inline()`` приводит элемент списка к требуемому в условии виду ("название" - "детали").
Соотвественно, любой новый тип должен будет реализовывать этот интерфейс.
2. Несмотря на возможное неограниченное количество типов, экран деталей этих типов в данном приложении всего один.
Такое удобство было достигнуто за счёт рефлексии. 
Соотвественно, при добавлении любого нового типа программисту не нужно волноваться об экране, на котором отобразятся все детали данного типа.
Приложение само умеет подсчитывать количество полей любого типа и в завимости от этого колиечества сгенерирует элемент списка для каждого из этих полей и присвоит туда истинное значение этого поля вместе с его названием.
