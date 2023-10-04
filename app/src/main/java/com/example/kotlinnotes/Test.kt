fun main() {
    println("Hello")

    // creating a list and accessing an element

    // create a list on integers
    val numList = listOf(41, 99, 100)
    // get last value
    // Java way:
    var lastElement = numList.get(numList.size - 1)
    // We can do this like in JS with Kotlin!! So sick!!
    lastElement = numList[numList.size - 1]
    // Even easier!!
    lastElement = numList[numList.lastIndex]
    // Kotlin is crazy lol... this is so nice.
    lastElement = numList.last()

    println(lastElement)


    // type inference
    val first: String = "Linda"
    val last = "Meacham"
    var age : Int
    age = 31
    var friends: List<String> = listOf("Michael", "Winnie")
    // listOf is an immutable list

    // immutability
    // val cannot be reassigned
    // var can be reassigned
    age += 1
    println(age)
    val otherFriends = mutableListOf("Amy", "Ann")
    otherFriends[0] = "another friend"
    println(otherFriends[0])

    // null safety
    findFriendScore(otherFriends)
    findFriendScore(null)

    // this line will cause a compile error because String cannot be null unless we allow it to be
//    val bad: String = null

    // this line is good!
    var name: String? = null
    // however, now we can't safely use methods on name since name could be null
    // this would also be a compile error
//    val badLength = name.length

    // in order to be able to safely call methods on variables which could be null, we could do:
    var nameLength = name?.length ?: 0;
    println(nameLength)
    name = "Michael"
    println(name?.length)
}

fun findFriendScore(friends: MutableList<String>?): Int {
    if (friends == null) return 0;

    var score = 0
    for (friend in friends) {
        score += friend.length
    }
    return score
}
