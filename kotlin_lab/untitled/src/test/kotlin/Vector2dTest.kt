import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import model.kotlin.Vector2d


class Vector2dTest : ShouldSpec({
    context("precedes test") {
        should("should return true if one vector precedes the other") {
            val v1 = Vector2d(1, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)

            (v1 < v3) shouldBe false
            (v1 < v2) shouldBe true
        }
    }

    context("follows test") {
        should("should return true if one vector followsthe other") {
            val v1 = Vector2d(1, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)

            (v3 > v1) shouldBe false
            (v2 > v1) shouldBe true
        }
    }

    context("upperRight test") {
        should("upperRight should return the upper right corner of the rectangle given between two vectors") {
            val v1 = Vector2d(1, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)
            val v1v2 = Vector2d(1, 3)
            val v1v3 = Vector2d(2, 2)

            v1.upperRight(v2) shouldBe v1v2
            v3.upperRight(v1) shouldBe v1v3

            v2.upperRight(v2) shouldBe v1v2
            v1.upperRight(v3) shouldBe v1v3
        }
    }
    context("lowerLeft test") {
        should("lowerLeft should return the upper right corner of the rectangle given between two vectors") {
            val v1 = Vector2d(-2, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)
            val v1v2 = Vector2d(-2, 2)
            val v1v3 = Vector2d(-2, -7)

            v1.lowerLeft(v2) shouldBe v1v2
            v1.lowerLeft(v3) shouldBe v1v3

            v2.lowerLeft(v1) shouldBe v1v2
            v3.lowerLeft(v1) shouldBe v1v3
        }
    }

    context("add test") {
        should("\'+\' should add two vectors") {
            val v1 = Vector2d(-2, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)

            v1 + v2 shouldBe Vector2d(-1, 5)
            v1 + v3 shouldBe Vector2d(0, -5)
        }
    }

    context("subtract test") {
        should("\'+\' should subtract one vector from the other") {
            val v1 = Vector2d(-2, 2)
            val v2 = Vector2d(1, 3)
            val v3 = Vector2d(2, -7)

            v1 - v2 shouldBe Vector2d(-3, -1)
            v1 - v3 shouldBe Vector2d(-4, 9)
        }
    }

    context("opposite test") {
        should("opposite should return a vector of opposite values") {
            val v1 = Vector2d(-2, 2)
            val v2 = Vector2d(1, 0)

            v1.opposite() shouldBe Vector2d(2, -2)
            v2.opposite() shouldBe Vector2d(-1, 0)
        }
    }

})