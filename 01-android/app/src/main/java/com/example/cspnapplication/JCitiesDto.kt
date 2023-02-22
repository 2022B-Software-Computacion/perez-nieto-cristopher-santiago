package com.example.cspnapplication

class JCitiesDto (
    public var name: String?,
    public var state: String?,
    public var country: String?,
    public var capital: Boolean?,
    public var popultaion: Long?,
    public var regions: List<String>?
    ) {
    override fun toString(): String {
        return "${name} - ${country}"
    }


}