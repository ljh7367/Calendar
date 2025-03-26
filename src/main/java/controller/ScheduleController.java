package controller;


@RestController
@RequestMapping("/schedules")
    public class ScheduleController {

        private final ScheduleService scheduleService;

        public ScheduleController(ScheduleService scheduleService) {
            this.scheduleService = scheduleService;
        }

        // 일정 조회(전체)
        @GetMapping
        public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
            return new ResponseEntity<>(scheduleService.findAllSchedules(), HttpStatus.OK);
        }

        // 일정 조회(단건)
        @GetMapping("/{id}")
        public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
            return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
        }

        // 일정 생성
        @PutMapping
        public ResponseEntity


        // 일정 삭제
        @DeleteMapping("/{id}")
        public ResponseEntity


        // 일정 수정
        @UpdateMapping("/{id}")
