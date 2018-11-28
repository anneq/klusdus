package com.qualogy.klusdus.google.model.systemintent

data class SystemIntent(val intent: String = "actions.intent.OPTION",
                        val data: InputData? = null)

interface InputData

