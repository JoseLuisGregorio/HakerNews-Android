package com.jose.hackernews.data.model

import com.google.gson.annotations.SerializedName

data class HackerNewsDTO(
    @SerializedName("hits") var hits: ArrayList<Hits> = arrayListOf(),
    @SerializedName("nbHits") var nbHits: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("nbPages") var nbPages: Int? = null,
    @SerializedName("hitsPerPage") var hitsPerPage: Int? = null,
    @SerializedName("exhaustiveNbHits") var exhaustiveNbHits: Boolean? = null,
    @SerializedName("exhaustiveTypo") var exhaustiveTypo: Boolean? = null,
    @SerializedName("exhaustive") var exhaustive: Exhaustive? = Exhaustive(),
    @SerializedName("query") var query: String? = null,
    @SerializedName("params") var params: String? = null,
    @SerializedName("processingTimeMS") var processingTimeMS: Int? = null,
    @SerializedName("processingTimingsMS") var processingTimingsMS: ProcessingTimingsMS? = ProcessingTimingsMS()
)

data class Author(
    @SerializedName("value") var value: String? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf()
)

data class CommentText(
    @SerializedName("value") var value: String? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("fullyHighlighted") var fullyHighlighted: Boolean? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf()
)

data class StoryTitle(
    @SerializedName("value") var value: String? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf()
)

data class StoryUrl(
    @SerializedName("value") var value: String? = null,
    @SerializedName("matchLevel") var matchLevel: String? = null,
    @SerializedName("matchedWords") var matchedWords: ArrayList<String> = arrayListOf()
)

data class HighlightResult(
    @SerializedName("author") var author: Author? = Author(),
    @SerializedName("comment_text") var commentText: CommentText? = CommentText(),
    @SerializedName("story_title") var storyTitle: StoryTitle? = StoryTitle(),
    @SerializedName("story_url") var storyUrl: StoryUrl? = StoryUrl()
)

data class Hits(
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("points") var points: String? = null,
    @SerializedName("story_text") var storyText: String? = null,
    @SerializedName("comment_text") var commentText: String? = null,
    @SerializedName("num_comments") var numComments: String? = null,
    @SerializedName("story_id") var storyId: Int? = null,
    @SerializedName("story_title") var storyTitle: String? = null,
    @SerializedName("story_url") var storyUrl: String? = null,
    @SerializedName("parent_id") var parentId: Int? = null,
    @SerializedName("created_at_i") var createdAtI: Int? = null,
    @SerializedName("_tags") var Tags: ArrayList<String> = arrayListOf(),
    @SerializedName("objectID") var objectID: String? = null,
    @SerializedName("_highlightResult") var HighlightResult: HighlightResult? = HighlightResult()
)

data class Exhaustive(
    @SerializedName("nbHits") var nbHits: Boolean? = null,
    @SerializedName("typo") var typo: Boolean? = null
)

data class Format(
    @SerializedName("highlighting") var highlighting: Int? = null,
    @SerializedName("total") var total: Int? = null
)

data class AfterFetch(
    @SerializedName("format") var format: Format? = Format(),
    @SerializedName("total") var total: Int? = null
)

data class Fetch(
    @SerializedName("total") var total: Int? = null
)

data class Load(
    @SerializedName("dicts") var dicts: Int? = null,
    @SerializedName("total") var total: Int? = null
)

data class GetIdx(
    @SerializedName("load") var load: Load? = Load(),
    @SerializedName("total") var total: Int? = null
)

data class ProcessingTimingsMS(
    @SerializedName("afterFetch") var afterFetch: AfterFetch? = AfterFetch(),
    @SerializedName("fetch") var fetch: Fetch? = Fetch(),
    @SerializedName("getIdx") var getIdx: GetIdx? = GetIdx(),
    @SerializedName("total") var total: Int? = null
)