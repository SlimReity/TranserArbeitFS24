package com.example.sitetrackermobile.model

import java.time.Instant
import java.util.*

data class TblProjectStructure(
    val pstrucId: Int?,
    val pstrucParentid: Int?,
    val pstrucToplevelprojectid: Int?,
    val pstrucName: String?,
    val pstrucDescription: String?,
    val pstrucRemark: String?,
    val pstrucIssite: Boolean?,
    val pstrucSerconadressid: Int?,
    val pstrucIsactive: Boolean?,
    val pstrucErpnumber: String?,
    val pstrucDefaultspid: Int?,
    val pstrucCreator: String?,
    val pstrucCreationdate: Instant?,
    val pstrucModifiedby: String?,
    val pstrucModifiedat: Instant?,
    val pstrucDeletedat: Instant?,
    val pstrucEntrynumber: UUID?,
    val pstrucErpTkz: String?,
    val pstrucErpRevision: String?,
    val pstrucErpBaselineid: UUID?,
    val pstrucIslocked: Boolean?
)
