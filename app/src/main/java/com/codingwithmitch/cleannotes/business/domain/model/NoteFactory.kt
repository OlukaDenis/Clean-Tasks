package com.codingwithmitch.cleannotes.business.domain.model

import android.icu.text.CaseMap
import com.codingwithmitch.cleannotes.business.domain.utils.DateUtil
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.ArrayList

@Singleton
class NoteFactory @Inject constructor(
    private val dateUtil: DateUtil
) {

    fun createSingleNote(
        id: String? = null,
        title: String,
        body: String? = null
    ): Note = Note(
        id = id ?: UUID.randomUUID().toString(),
        title = title,
        body = body ?: "",
        created_at = dateUtil.getCurrentTimestamp(),
        updated_at = dateUtil.getCurrentTimestamp()
    )

    fun createNoteList(numNotes: Int): List<Note> {
        val list: ArrayList<Note> = ArrayList()
        for (i in 0 until numNotes) {
            list.add(
                createSingleNote(
                    id = null,
                    title = UUID.randomUUID().toString(),
                    body = UUID.randomUUID().toString()
                )
            )
        }
        return list
    }
}