import org.junit.Assert.*
import org.junit.Test

class MainKtTest {
    private val service = WallService()

    @Test
    fun addPost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        service.add(post)
        val result = service.add(post)
        assertEquals(expected.id, result.id)

    }

    @Test
    fun likePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 1

        var copy = service.add(post)
        copy = service.add(copy)

        val result = service.likeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun removePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        copy = service.add(copy)
        service.remove(1)

        val result = service.sizeWallPosts()
        assertEquals(expected, result)
    }

    @Test
    fun dislikePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = 2

        var copy = service.add(post)
        copy = service.add(copy)
        service.dislikeById(1)

        val result = service.dislikeById(1)
        assertEquals(expected, result)

    }

    @Test
    fun updatePost() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = Post (
            id = 1,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        val isResult = service.update(expected)
        val result = service.get(expected.id)
        assertTrue(isResult && result.ownerId == copy.ownerId && result.date == copy.date)

    }


    @Test
    fun updatePostNotExistId() {

        val post = Post (
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        val expected = Post (
            id = 4,
            ownerId = 0,
            fromId = 0,
            createdBy = 0,
            date = "12.12.2020",
            text = "Text test",
            replyOwnerId = 0,
            replyPostIid = 0,
            friendsOnly = false,
            postType = "first",
            signerId = 1234,
            canPin = false,
            canDelete = true,
            canEdit = false,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            donut = Donut(),
            postponedId = 0,
            comments = Comments(),
            copyright = Copyright(),
            likes = Likes(),
            reposts = Repost(),
            views = Views()
        )

        service.add(post)
        val copy = post.copy(ownerId = 2, date = "18.12.2020" )
        service.add(copy)

        assertFalse(service.update(expected))

    }


}