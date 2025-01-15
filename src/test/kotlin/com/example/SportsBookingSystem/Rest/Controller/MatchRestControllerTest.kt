package com.example.SportsBookingSystem.Rest.Controller
import com.example.SportsBookingSystem.Controller.MatchController
import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.TeamMatchLinkEntity
import com.example.SportsBookingSystem.Mapper.MatchMapper
import com.example.SportsBookingSystem.Service.MatchService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class MatchRestControllerTest {
  private lateinit var matchService: MatchService
  private lateinit var matchRestController: MatchRestController
  private lateinit var matchMapper: MatchMapper

@BeforeEach
 fun setUp()
 {
  matchService = mockk()
  matchMapper = mockk<MatchMapper>()
  matchRestController = MatchRestController(matchService)
 }

@AfterEach
 fun tearDown()
 {
 clearAllMocks()
 }

@Test
 fun findById_than_returnID()
 {
  val playerMatchLinks = setOf(
   mockk<PlayerMatchLinkEntity>(relaxed = true),
   mockk<PlayerMatchLinkEntity>(relaxed = true)
  )
  val teamMatchLinks = setOf(
   mockk<TeamMatchLinkEntity>(relaxed = true),
   mockk<TeamMatchLinkEntity>(relaxed = true)
  )

  val match =  MatchEntity(
   1,
   1,
   "",
   "",
   playerMatchLinks,
   teamMatchLinks
  )
  val matchDTO =  MatchGetDTO(
   1,
   1,
   "",
   "",
   playerMatchLinks,
   teamMatchLinks
  )

  every { matchService.mapEnitiyToGetDTO(any()) } returns matchDTO
  every { matchService.findByMatchId(1) } returns match
  val result = matchRestController.findById(1)
  assertEquals(matchDTO, result)
  verify { matchService.mapEnitiyToGetDTO(any()) }
 }

@Test
 fun findAll_than_return_all()
 {
  val playerMatchLinks = setOf(
   mockk<PlayerMatchLinkEntity>(relaxed = true),
   mockk<PlayerMatchLinkEntity>(relaxed = true)
  )
  val teamMatchLinks = setOf(
   mockk<TeamMatchLinkEntity>(relaxed = true),
   mockk<TeamMatchLinkEntity>(relaxed = true)
  )

  val match =  MatchEntity(
   1,
   1,
   "",
   "",
   playerMatchLinks,
   teamMatchLinks
  )
  val matchDTO =  MatchGetDTO(
   1,
   1,
   "",
   "",
   playerMatchLinks,
   teamMatchLinks
  )
  val listOfDTOs = listOf(matchDTO)
  every{matchService.finalAllGetDTO()} returns listOfDTOs
  val result = matchRestController.findAll()
  assertEquals(listOfDTOs, result)
  verify { matchService.finalAllGetDTO() }
 }

@Test
 fun findAllByStatus_than_return_status()
 {
  val playerMatchLinks = setOf(
   mockk<PlayerMatchLinkEntity>(relaxed = true),
   mockk<PlayerMatchLinkEntity>(relaxed = true)
  )
  val teamMatchLinks = setOf(
   mockk<TeamMatchLinkEntity>(relaxed = true),
   mockk<TeamMatchLinkEntity>(relaxed = true)
  )

  val match =  MatchEntity(
   1,
   1,
   "",
   "lol123",
   playerMatchLinks,
   teamMatchLinks
  )
  val matchDTO =  MatchGetDTO(
   1,
   1,
   "",
   "lol123",
   playerMatchLinks,
   teamMatchLinks
  )
  val listOfDTOs = listOf(matchDTO)
  every{matchService.finalAllGetDTO()} returns listOfDTOs
  every { matchService.findAllByStatus(match.status) } returns listOfDTOs
  val result = matchRestController.findAllByStatus(match.status)
  assertEquals(listOfDTOs, result)
 }


@Test
 fun findByDescription()
 {
  val playerMatchLinks = setOf(
   mockk<PlayerMatchLinkEntity>(relaxed = true),
   mockk<PlayerMatchLinkEntity>(relaxed = true)
  )
  val teamMatchLinks = setOf(
   mockk<TeamMatchLinkEntity>(relaxed = true),
   mockk<TeamMatchLinkEntity>(relaxed = true)
  )

  val match =  MatchEntity(
   1,
   1,
   "lol123",
   "lol123",
   playerMatchLinks,
   teamMatchLinks
  )
  val matchDTO =  MatchGetDTO(
   1,
   1,
   "lol123",
   "lol123",
   playerMatchLinks,
   teamMatchLinks
  )
  val listOfDto = listOf(matchDTO)
  every { matchService.findAllByDesciption(any()) } returns listOfDto
  val result = matchRestController.findByDescription(match.description)
  kotlin.test.assertEquals(listOfDto,result)
  verify { matchService.findAllByDesciption(any()) }
 }
}